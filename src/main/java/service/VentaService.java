package service;

import dao.impl.RepuestoDAOImpl;
import dao.impl.VentaDAOImpl;
import dao.impl.VentaRepuestoDAOImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Precio;
import model.Repuesto;
import model.Venta;
import model.VentaRepuesto;

public class VentaService {
    
    private final Connection connection;
    private final VentaDAOImpl ventaDAO;
    private final RepuestoDAOImpl repuestoDAO;
    private final VentaRepuestoDAOImpl VentaRepuestoDAO;

    public VentaService(VentaDAOImpl ventaDAO, RepuestoDAOImpl repuestoDAO, VentaRepuestoDAOImpl VentaRepuestoDAO, Connection connection) {
        this.ventaDAO = ventaDAO;
        this.repuestoDAO = repuestoDAO;
        this.VentaRepuestoDAO = VentaRepuestoDAO;
        this.connection = connection;
    }
    
    public void agregarVenta(Venta venta, List<Repuesto> listaRepuestos) throws SQLException{
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Realizar operaciones de la transacción
            ventaDAO.crearVenta(venta);
            
            List<Venta> listaVentas= ventaDAO.obtenerVentas();
            venta = listaVentas.get(listaVentas.size() - 1);
            //System.out.println("IDVenta: " + venta.getId_venta());
            
            Map<Repuesto, Integer> contador = new HashMap<>();
            
            for(Repuesto repuesto : listaRepuestos){
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }
            
            for(Map.Entry<Repuesto, Integer> entry : contador.entrySet()){
                Repuesto repuesto = entry.getKey();
                int cantidad = entry.getValue();
                
                //System.out.println("Repuesto: " + repuesto.getNombreRepuesto().getNombre_repuesto() + ". Cantidad: " + cantidad );
                
                VentaRepuestoDAO.crearVentaRepuesto(venta.getId_venta(), repuesto.getId_repuesto(), cantidad);
            }
            
            descontarStockPorLista(listaRepuestos);

            connection.commit(); // Confirmar la transacción

        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState); // Restablecer auto-commit al estado original
        }
    }
    
    public List<Venta> listarVentas() {
        return ventaDAO.obtenerVentas();
    }
    
    public Venta obtenerVentaPorId(int id) {
        return ventaDAO.obtenerVenta(id);
    }
    
    public void editarVenta(Venta venta){
        ventaDAO.actualizarVenta(venta);
    }
    
    public void eliminarVentaPorId(int id) throws SQLException{
        
        boolean autoCommitState = connection.getAutoCommit(); 
        connection.setAutoCommit(false);
        
        List<Repuesto> listaRepuestosEliminar = repuestoDAO.obtenerRepuestosPorIdVenta(id);
        
        try {
            VentaRepuestoDAO.eliminarVentaRepuestoPorVenta(id);
            
            ventaDAO.eliminarVenta(id);
            
            if(!listaRepuestosEliminar.isEmpty()){
                aumentarStockPorLista(listaRepuestosEliminar);
            }
            
            connection.commit();

        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState);
        }
    }

    public void descontarStockPorIdRepuesto(Repuesto repuesto){
        Repuesto repAux = repuestoDAO.obtenerRepuesto(repuesto.getId_repuesto());
        repAux.setStock(repAux.getStock() - 1);
        repuestoDAO.actualizarRepuesto(repAux);
    }
    
    public void descontarStockPorLista(List<Repuesto> listaRepuestos){
        for(Repuesto rep : listaRepuestos){
            Repuesto repAux = repuestoDAO.obtenerRepuesto(rep.getId_repuesto());
            repAux.setStock(repAux.getStock() - 1);
            repuestoDAO.actualizarRepuesto(repAux);
        }
    }
    
    public void aumentarStockPorLista(List<Repuesto> listaRepuestos){
        for(Repuesto rep : listaRepuestos){
            Repuesto repAux = repuestoDAO.obtenerRepuesto(rep.getId_repuesto());
            repAux.setStock(repAux.getStock() + 1);
            repuestoDAO.actualizarRepuesto(repAux);
        }
    }

    public Precio obtenerPrecioRepuestoPorFechaVenta(int idVenta, Repuesto repuesto) {
        
        Venta venta = ventaDAO.obtenerVenta(idVenta);
        List<Precio> listaPrecios = repuesto.getListaPrecios();
        Precio precioActualizado = listaPrecios.stream()
        .filter(precio -> !precio.getFechaPrecio().isAfter(venta.getFecha_venta())) // Filtra precios anteriores o iguales a la fecha de venta
        .max(Comparator.comparing(Precio::getFechaPrecio))              // Encuentra el precio con la fecha más reciente
        .orElse(null); // Maneja el caso si no hay precio válido
        return precioActualizado;
    }

    public List<Venta> busquedaDeVentas(int dia, int mes, int anio) {
        
        //System.out.println(dia + " " + mes + " " + anio);
        
        LocalDateTime fechaBuscar = LocalDateTime.of(anio, mes, dia, 0, 0);
        
        return ventaDAO.busquedaDeVentas(fechaBuscar);
    }

    public void actualizarListaRepuestosPorVenta(Venta venta, List<Repuesto> listaRepuestosNuevos) throws SQLException {
        List<Repuesto> listaRepuestosAnterior = repuestoDAO.obtenerRepuestosPorIdVenta(venta.getId_venta());
        List<VentaRepuesto> listaVentaRepuesto = VentaRepuestoDAO.obtenerVentaRepuestoPorVenta(venta.getId_venta());
        
        //Elimino todo lo respuecto a tabla VentaRepuestos
        for(VentaRepuesto venRep : listaVentaRepuesto){
            VentaRepuestoDAO.eliminarVentaRepuesto(venRep.getId_venta(), venRep.getId_repuesto());
        }
                
        //Devuelvo el stock orinal de cada repuesto
        for(Repuesto rep : listaRepuestosAnterior){
            rep.setStock(rep.getStock() + 1);
            repuestoDAO.actualizarRepuesto(rep);
        }
        
        
        //Agrego los nuevos VentaRepuestos
        //agregarVenta(venta, listaRepuestosNuevos);
        
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Realizar operaciones de la transacción
            List<Venta> listaVentas= ventaDAO.obtenerVentas();
            
            for(Venta ven : listaVentas){
                if(ven.getId_venta() == venta.getId_venta()){
                    venta = ven;
                    break;
                }
            }
            
            Map<Repuesto, Integer> contador = new HashMap<>();
            
            for(Repuesto repuesto : listaRepuestosNuevos){
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }
            
            for(Map.Entry<Repuesto, Integer> entry : contador.entrySet()){
                Repuesto repuesto = entry.getKey();
                int cantidad = entry.getValue();
                
                //System.out.println("Repuesto: " + repuesto.getNombreRepuesto().getNombre_repuesto() + ". Cantidad: " + cantidad );
                
                VentaRepuestoDAO.crearVentaRepuesto(venta.getId_venta(), repuesto.getId_repuesto(), cantidad);
            }
            
            descontarStockPorLista(listaRepuestosNuevos);

            connection.commit(); // Confirmar la transacción

        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState); // Restablecer auto-commit al estado original
        }
    }

    public void agregarRepuestosAVenta(Venta venta, List<Repuesto> listaRepuestos) throws SQLException {
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            List<Venta> listaVentas = ventaDAO.obtenerVentas();
            venta = listaVentas.get(venta.getId_venta());
            // Eliminar los repuestos existentes de la venta antes de agregar los nuevos
            VentaRepuestoDAO.eliminarVentaRepuestoPorVenta(venta.getId_venta());

            Map<Repuesto, Integer> contador = new HashMap<>();

            
            for(Repuesto repuesto : listaRepuestos){
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }
            
            for(Map.Entry<Repuesto, Integer> entry : contador.entrySet()){
                Repuesto repuesto = entry.getKey();
                int cantidad = entry.getValue();
                
                //System.out.println("Repuesto: " + repuesto.getNombreRepuesto().getNombre_repuesto() + ". Cantidad: " + cantidad );
                
                VentaRepuestoDAO.crearVentaRepuesto(venta.getId_venta(), repuesto.getId_repuesto(), cantidad);
            }
            
            descontarStockPorLista(listaRepuestos);

            connection.commit(); // Confirmar la transacción

        } catch (SQLException e) {
            try {
                connection.rollback(); // Revertir en caso de error
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState); // Restablecer auto-commit al estado original
        }
    }

}

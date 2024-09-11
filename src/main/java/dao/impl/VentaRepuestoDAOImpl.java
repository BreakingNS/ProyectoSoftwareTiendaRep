package dao.impl;

import dao.interfaces.VentaRepuestoDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Repuesto;
import model.Venta;
import model.VentaRepuesto;

public class VentaRepuestoDAOImpl implements VentaRepuestoDAO{

    private final Connection connection;
    private final String SENTENCIA_CREAR_VENTA_REPUESTO = 
            "INSERT INTO TiendaLocal.Venta_Repuesto (id_venta, id_repuesto, cantidad_repuestos) VALUES ( ? , ? , ?)";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto ORDER BY id_venta ASC, id_repuesto ASC";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_VENTA = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ? ORDER BY id_venta ASC, id_repuesto ASC";
    private final String SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_REPUESTO = 
            "SELECT * FROM TiendaLocal.Venta_Repuesto WHERE id_repuesto = ? ORDER BY id_venta ASC, id_repuesto ASC";
    private final String SENTENCIA_ACTUALIZAR_AGREGAR_VENTA_REPUESTO_POR_VENTA = 
            "UPDATE TiendaLocal.Venta_Repuesto SET cantidad_repuestos = ? WHERE id_venta = ? AND id_repuesto = ?";
    private final String SENTENCIA_ACTUALIZAR_ELIMINAR_VENTA_REPUESTO_POR_REPUESTO = 
            "UPDATE TiendaLocal.Venta_Repuesto SET cantidad_repuestos = ? WHERE id_venta = ? AND id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_VENTA_REPUESTO = 
            "DELETE FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ? AND id_repuesto = ?";
    private final String SENTENCIA_ELIMINAR_VENTA_REPUESTO_POR_VENTA = 
            "DELETE FROM TiendaLocal.Venta_Repuesto WHERE id_venta = ?";
    
    
    public VentaRepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public void crearVentaRepuesto(Venta venta, List<Repuesto> listaRepuestos) {
        for(Repuesto repuesto : listaRepuestos){
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_VENTA_REPUESTO);
                preparedStatement.setInt(1, venta.getId_venta());
                preparedStatement.setInt(2, repuesto.getId_repuesto());
                preparedStatement.setInt(3, obtenerCantidadRepuestos(listaRepuestos, repuesto.getId_repuesto()));
                preparedStatement.executeUpdate();
            } catch (SQLException ex) {
                Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestos() {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_REPUESTOS);
            ResultSet repuesto_VentaResultado = preparedStatement.executeQuery();
            
            while(repuesto_VentaResultado.next()){
                int idVenta = repuesto_VentaResultado.getInt("id_venta");
                int idRepuesto = repuesto_VentaResultado.getInt("id_repuesto");
                int cantidadRep = repuesto_VentaResultado.getInt("cantidad_repuestos");
                
                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto,cantidadRep);
                
                listaVentaRepuestos.add(ventaRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVentaRepuestos;
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestoPorVenta(int id_venta) {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_VENTA);
            preparedStatement.setInt(1, id_venta);
            ResultSet repuesto_VentaResultado = preparedStatement.executeQuery();
            
            while(repuesto_VentaResultado.next()){
                int idVenta = repuesto_VentaResultado.getInt("id_venta");
                int idRepuesto = repuesto_VentaResultado.getInt("id_repuesto");
                int cantidadRep = repuesto_VentaResultado.getInt("cantidad_repuestos");
                
                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto,cantidadRep);
                
                listaVentaRepuestos.add(ventaRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaVentaRepuestos;
    }

    @Override
    public List<VentaRepuesto> obtenerVentaRepuestoPorRepuesto(int id_repuesto) {
        List<VentaRepuesto> listaVentaRepuestos = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_VENTA_REPUESTOS_POR_REPUESTO);
            preparedStatement.setInt(1, id_repuesto);
            ResultSet repuesto_VentaResultado = preparedStatement.executeQuery();

            while(repuesto_VentaResultado.next()){
                int idVenta = repuesto_VentaResultado.getInt("id_venta");
                int idRepuesto = repuesto_VentaResultado.getInt("id_repuesto");
                int cantidadRep = repuesto_VentaResultado.getInt("cantidad_repuestos");
                
                VentaRepuesto ventaRepuesto = new VentaRepuesto(idVenta, idRepuesto,cantidadRep);

                listaVentaRepuestos.add(ventaRepuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaVentaRepuestos;
    }
    
    @Override
    public void actualizarAgregarVentaRepuestoPorVenta(int id_venta, List<Repuesto> listaRepuestosNuevos) {
        VentaRepuestoDAOImpl ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        
        List<VentaRepuesto> listaRepuestosActualizar = ventaRepuestoDAO.obtenerVentaRepuestoPorVenta(id_venta);
        List<VentaRepuesto> listaRepuestosNueva = ventaRepuestoDAO.crearVentaRepuestoAuxiliar(listaRepuestosNuevos);
        
        for (VentaRepuesto ventaRep : listaRepuestosNueva) {
            boolean existe = false;
            for (VentaRepuesto ventaRepuesto : listaRepuestosActualizar) {
                if (ventaRepuesto.getId_repuesto() == ventaRep.getId_repuesto()) {
                    ventaRepuesto.setCantidad_repuestos(ventaRepuesto.getCantidad_repuestos() + ventaRep.getCantidad_repuestos());
                    existe = true;

                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_AGREGAR_VENTA_REPUESTO_POR_VENTA);
                        preparedStatement.setInt(1, ventaRepuesto.getCantidad_repuestos());
                        preparedStatement.setInt(2, id_venta);
                        preparedStatement.setInt(3, ventaRepuesto.getId_repuesto());
                        preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }
            if (!existe) {
                VentaDAOImpl ventaDAO = new VentaDAOImpl(connection);
                Venta venta = ventaDAO.obtenerVenta(id_venta);
                crearVentaRepuesto(venta, listaRepuestosNuevos);
            }
        }
    }
/*
    
    @Override
    public void actualizarAgregarVentaRepuestoPorVenta(int id_venta, List<Repuesto> listaRepuestosNuevos) {
        VentaRepuestoDAOImpl ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        
        List<VentaRepuesto> listaRepuestosActualizar = ventaRepuestoDAO.obtenerVentaRepuestoPorVenta(id_venta);
        List<VentaRepuesto> listaRepuestosNueva = ventaRepuestoDAO.crearVentaRepuestoAuxiliar(listaRepuestosNuevos);
        
        for(VentaRepuesto ventaRepuesto : listaRepuestosActualizar){   
            for(VentaRepuesto ventaRep : listaRepuestosNueva){
                if(ventaRepuesto.getId_repuesto() == ventaRep.getId_repuesto()){
                    ventaRepuesto.setCantidad_repuestos(ventaRepuesto.getCantidad_repuestos() + ventaRep.getCantidad_repuestos());
                
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_AGREGAR_VENTA_REPUESTO_POR_VENTA);
                        preparedStatement.setInt(1, ventaRepuesto.getId_repuesto());
                        preparedStatement.setInt(2, ventaRepuesto.getCantidad_repuestos());
                        preparedStatement.setInt(3, id_venta);
                        preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
*/
    
    @Override
    public void actualizarEliminarVentaRepuestoPorRepuesto(int id_venta, List<Repuesto> listaRepuestosEliminar) {
        VentaRepuestoDAOImpl ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);

        List<VentaRepuesto> listaRepuestosActualizar = ventaRepuestoDAO.obtenerVentaRepuestoPorVenta(id_venta);
        List<VentaRepuesto> listaRepuestosNueva = ventaRepuestoDAO.crearVentaRepuestoAuxiliar(listaRepuestosEliminar);

        for (VentaRepuesto ventaRep : listaRepuestosNueva) {
            boolean existe = false;
            for (VentaRepuesto ventaRepuesto : listaRepuestosActualizar) {
                if (ventaRepuesto.getId_repuesto() == ventaRep.getId_repuesto()) {
                    // Restar las cantidades
                    int nuevaCantidad = ventaRepuesto.getCantidad_repuestos() - ventaRep.getCantidad_repuestos();
                    existe = true;

                    try {
                        if (nuevaCantidad > 0) {
                            // Actualizar la cantidad si es mayor a 0
                            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ELIMINAR_VENTA_REPUESTO_POR_REPUESTO);
                            preparedStatement.setInt(1, ventaRepuesto.getId_repuesto());
                            preparedStatement.setInt(2, nuevaCantidad);
                            preparedStatement.setInt(3, id_venta);
                            preparedStatement.executeUpdate();
                        } else {
                            // Eliminar la relación si la cantidad es 0 o menor
                            PreparedStatement deleteStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_VENTA_REPUESTO);
                            deleteStatement.setInt(1, id_venta);
                            deleteStatement.setInt(2, ventaRepuesto.getId_repuesto());
                            deleteStatement.executeUpdate();
                        }
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    break;
                }
            }

            if (!existe) {
                // No se hace nada si el repuesto no existe en la lista actual
                // Si se requiere lógica adicional, puede añadirse aquí
            }
        }

    }
    
    /*
    @Override
    public void actualizarEliminarVentaRepuestoPorRepuesto(int id_venta, List<Repuesto> listaRepuestosEliminar) {
        VentaRepuestoDAOImpl ventaRepuestoDAO = new VentaRepuestoDAOImpl(connection);
        
        List<VentaRepuesto> listaRepuestosActualizar = ventaRepuestoDAO.obtenerVentaRepuestoPorVenta(id_venta);
        List<VentaRepuesto> listaRepuestosNueva = ventaRepuestoDAO.crearVentaRepuestoAuxiliar(listaRepuestosEliminar);
        
        for(VentaRepuesto ventaRepuesto : listaRepuestosActualizar){   
            for(VentaRepuesto ventaRep : listaRepuestosNueva){
                if(ventaRepuesto.getId_repuesto() == ventaRep.getId_repuesto()){
                    ventaRepuesto.setCantidad_repuestos(ventaRepuesto.getCantidad_repuestos() - ventaRep.getCantidad_repuestos());
                
                    try {
                        PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_ELIMINAR_VENTA_REPUESTO_POR_REPUESTO);
                        preparedStatement.setInt(1, ventaRepuesto.getCantidad_repuestos());
                        preparedStatement.setInt(2, id_venta);
                        preparedStatement.setInt(3, ventaRepuesto.getId_repuesto());
                        preparedStatement.executeUpdate();
                    } catch (SQLException ex) {
                        Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }
    */
    

    @Override
    public void eliminarVentaRepuesto(int id_venta, int id_repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_VENTA_REPUESTO);
            preparedStatement.setInt(1, id_venta);
            preparedStatement.setInt(2, id_repuesto);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarVentaRepuestoPorVenta(int id_venta) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_VENTA_REPUESTO_POR_VENTA);
            preparedStatement.setInt(1, id_venta);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private int obtenerCantidadRepuestos(List<Repuesto> listaRepuestos, int id_repuesto) {
        int cantidad = 0;
        for(Repuesto repuesto : listaRepuestos){
            if(repuesto.getId_repuesto() == id_repuesto){
                cantidad = cantidad + 1;
            }
        }
        
        return cantidad;
    }
    
    private List<VentaRepuesto> crearVentaRepuestoAuxiliar(List<Repuesto> listaRepuestos) {
        List<VentaRepuesto> listaVentaRepuesto = new ArrayList<>();
        Map<Integer, Integer> contadorRepuestos = new HashMap<>();

        // Cuenta la cantidad de cada repuesto
        for (Repuesto repuesto : listaRepuestos) {
            contadorRepuestos.put(repuesto.getId_repuesto(), 
                    contadorRepuestos.getOrDefault(repuesto.getId_repuesto(), 0) + 1);
        }

        // Crea objetos VentaRepuesto con las cantidades correctas
        for (Map.Entry<Integer, Integer> entry : contadorRepuestos.entrySet()) {
            int idRepuesto = entry.getKey();
            int cantidad = entry.getValue();
            VentaRepuesto ventaRep = new VentaRepuesto(1, idRepuesto, cantidad);
            listaVentaRepuesto.add(ventaRep);
        }

        return listaVentaRepuesto;
    }
}

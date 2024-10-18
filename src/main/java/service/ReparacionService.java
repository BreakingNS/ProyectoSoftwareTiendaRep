package service;

import dao.impl.FacturaDAOImpl;
import dao.impl.RepuestoDAOImpl;
import dao.impl.ReparacionDAOImpl;
import dao.impl.ReparacionRepuestoDAOImpl;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Precio;
import model.Repuesto;
import model.Reparacion;

public class ReparacionService {
    
    private final Connection connection;
    private final ReparacionDAOImpl reparacionDAO;
    private final RepuestoDAOImpl repuestoDAO;
    private final ReparacionRepuestoDAOImpl ReparacionRepuestoDAO;
    private final FacturaDAOImpl FacturaDAO;

    public ReparacionService(ReparacionDAOImpl reparacionDAO, RepuestoDAOImpl repuestoDAO, ReparacionRepuestoDAOImpl ReparacionRepuestoDAO, FacturaDAOImpl FacturaDAO,Connection connection) {
        this.reparacionDAO = reparacionDAO;
        this.repuestoDAO = repuestoDAO;
        this.ReparacionRepuestoDAO = ReparacionRepuestoDAO;
        this.FacturaDAO = FacturaDAO;
        this.connection = connection;
    }
    
    public void agregarReparacion(Reparacion reparacion, List<Repuesto> listaRepuestos) throws SQLException{
        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Realizar operaciones de la transacción
            reparacionDAO.crearReparacion(reparacion);
        
            List<Reparacion> listaReparaciones = reparacionDAO.obtenerReparaciones();
            reparacion = listaReparaciones.get(listaReparaciones.size()-1);
            
            Map<Repuesto, Integer> contador = new HashMap<>();
            
            for(Repuesto repuesto : listaRepuestos){
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }
            
            for(Map.Entry<Repuesto, Integer> entry : contador.entrySet()){
                Repuesto repuesto = entry.getKey();
                int cantidad = entry.getValue();
                                
                ReparacionRepuestoDAO.crearReparacionRepuesto(reparacion.getId_reparacion(), repuesto.getId_repuesto(), cantidad);
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
    
    public List<Reparacion> listarReparaciones() {
        return reparacionDAO.obtenerReparaciones();
    }
    
    public Reparacion obtenerReparacionPorId(int id) {
        return reparacionDAO.obtenerReparacion(id);
    }
    
    public void editarReparacionSoloEstado(Reparacion reparacion){
        reparacionDAO.actualizarReparacionSoloEstado(reparacion);
    }
    
    public void eliminarReparacionPorId(int id) throws SQLException{
        
        boolean autoCommitState = connection.getAutoCommit(); 
        connection.setAutoCommit(false); 
        try {
            reparacionDAO.eliminarReparacion(id);
        
            ReparacionRepuestoDAO.eliminarReparacionRepuestoPorReparacion(id);

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
    /*
    public void nuevaReparacion(Reparacion reparacion, List<Repuesto> listaRepuestos) throws SQLException {
        boolean autoCommitState = connection.getAutoCommit();
        connection.setAutoCommit(false);

        try {
            reparacionDAO.crearReparacion(reparacion); 
            
            ReparacionRepuestoDAO.crearReparacionRepuesto(reparacion, listaRepuestos);
            
            descontarStockPorLista(listaRepuestos);

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
    */
    public void descontarStockPorIdRepuesto(Repuesto repuesto){
        Repuesto repAux = repuestoDAO.obtenerRepuesto(repuesto.getId_repuesto());
        repAux.setStock(repAux.getStock() - 1);
        repuestoDAO.actualizarRepuesto(repAux);
    }
    
    public void descontarStockPorLista(List<Repuesto> listaRepuestos) {
        // Contador para saber cuántas veces se usa cada repuesto
        Map<Integer, Integer> contador = new HashMap<>();
        for (Repuesto rep : listaRepuestos) {
            contador.put(rep.getId_repuesto(), contador.getOrDefault(rep.getId_repuesto(), 0) + 1);
        }

        // Descontar el stock en base a la cantidad de cada repuesto
        for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            int idRepuesto = entry.getKey();
            int cantidad = entry.getValue();
            Repuesto repAux = repuestoDAO.obtenerRepuesto(idRepuesto);
            repAux.setStock(repAux.getStock() - cantidad);
            repuestoDAO.actualizarRepuesto(repAux);
        }
    }

    
    public void aumentarStockPorLista(List<Repuesto> listaRepuestos) {
        // Contador para saber cuántas veces se usa cada repuesto
        Map<Integer, Integer> contador = new HashMap<>();
        for (Repuesto rep : listaRepuestos) {
            contador.put(rep.getId_repuesto(), contador.getOrDefault(rep.getId_repuesto(), 0) + 1);
        }

        // Aumentar el stock en base a la cantidad de cada repuesto
        for (Map.Entry<Integer, Integer> entry : contador.entrySet()) {
            int idRepuesto = entry.getKey();
            int cantidad = entry.getValue();
            Repuesto repAux = repuestoDAO.obtenerRepuesto(idRepuesto);
            repAux.setStock(repAux.getStock() + cantidad);
            repuestoDAO.actualizarRepuesto(repAux);
        }
    }

    
    public List<Reparacion> listarReparacionesOrdenadasPorFechaActual() {
        return reparacionDAO.obtenerReparacionesOrdenadasPorFechaActual();
    }

    public List<Reparacion> busquedaDeReparacion(Reparacion reparacion/*, String pagadoNuevo*/) {
        List<Reparacion> listaReparaciones = reparacionDAO.busquedaDeReparaciones(reparacion);
        
        return listaReparaciones;
    }

    public void editarReparacionSoloTecnico(Reparacion reparacion) {
        reparacionDAO.actualizarReparacionSoloTecnico(reparacion);
    }
    
    public void editarReparacionCompleta(Reparacion reparacion, List<Repuesto> listaRepuestosSeleccionadosVIEJA, List<Repuesto> listaRepuestosSeleccionadosNUEVA) throws SQLException {

        boolean autoCommitState = connection.getAutoCommit(); 
        connection.setAutoCommit(false); 
        try {
            // Actualizar la reparación
            reparacionDAO.actualizarReparacionCompleto(reparacion);

            // Actualizar factura
            FacturaDAO.actualizarFactura(reparacion.getFactura());

            // Aumentar el stock del repuesto en base a la cantidad usada anteriormente
            aumentarStockPorLista(listaRepuestosSeleccionadosVIEJA);
            ReparacionRepuestoDAO.eliminarReparacionRepuestoPorReparacion(reparacion.getId_reparacion());

            // Contador para los repuestos seleccionados de la lista nueva
            Map<Repuesto, Integer> contador = new HashMap<>();
            for (Repuesto repuesto : listaRepuestosSeleccionadosNUEVA) {
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }

            // Crear nuevamente los repuestos seleccionados en la lista nueva
            for (Map.Entry<Repuesto, Integer> entry : contador.entrySet()) {
                Repuesto repuesto = entry.getKey();
                int cantidad = entry.getValue();
                ReparacionRepuestoDAO.crearReparacionRepuesto(reparacion.getId_reparacion(), repuesto.getId_repuesto(), cantidad);
            }

            // Descontar el stock de la lista nueva
            descontarStockPorLista(listaRepuestosSeleccionadosNUEVA);

            connection.commit(); 
        } catch (SQLException e) {
            connection.rollback(); 
            e.printStackTrace();
        } finally {
            connection.setAutoCommit(autoCommitState); 
        }
    }



    
    /*
    public void editarReparacionCompleta(Reparacion reparacion, List<Repuesto> listaRepuestosSeleccionadosFinal) throws SQLException {

        boolean autoCommitState = connection.getAutoCommit(); // Guardar el estado original
        connection.setAutoCommit(false); // Desactivar auto-commit
        try {
            // Actualizar la reparación
            reparacionDAO.actualizarReparacionCompleto(reparacion);
            Reparacion reparacionAct = reparacionDAO.obtenerReparacion(reparacion.getId_reparacion());

            // Map para contar repuestos seleccionados
            Map<Repuesto, Integer> contador = new HashMap<>();
            for (Repuesto repuesto : listaRepuestosSeleccionadosFinal) {
                contador.put(repuesto, contador.getOrDefault(repuesto, 0) + 1);
            }

            // Obtener los repuestos actuales de la reparación
            Map<Integer, Integer> repuestosActuales = (Map<Integer, Integer>) ReparacionRepuestoDAO.obtenerReparacionRepuestoPorReparacion(reparacionAct.getId_reparacion());

            // Comparar y actualizar la tabla intermedia Reparacion_Repuesto
            for (Map.Entry<Repuesto, Integer> entry : contador.entrySet()) {
                Repuesto repuesto = entry.getKey();
                int nuevaCantidad = entry.getValue();

                if (repuestosActuales.containsKey(repuesto.getId_repuesto())) {
                    int cantidadActual = repuestosActuales.get(repuesto.getId_repuesto());
                    if (cantidadActual != nuevaCantidad) {
                        // Actualizar cantidad si es diferente
                        ReparacionRepuestoDAO.actualizarReparacionRepuesto(reparacionAct.getId_reparacion(), repuesto.getId_repuesto(), nuevaCantidad);
                    }
                    repuestosActuales.remove(repuesto.getId_repuesto()); // Eliminar de repuestosActuales
                } else {
                    // Crear nuevo si no existía
                    ReparacionRepuestoDAO.crearReparacionRepuesto(reparacionAct.getId_reparacion(), repuesto.getId_repuesto(), nuevaCantidad);
                }
            }

            // Eliminar repuestos que ya no están en la nueva lista
            for (Integer idRepuesto : repuestosActuales.keySet()) {
                ReparacionRepuestoDAO.eliminarReparacionRepuesto(reparacionAct.getId_reparacion(), idRepuesto);
            }

            // Descontar stock de los repuestos seleccionados
            descontarStockPorLista(listaRepuestosSeleccionadosFinal);

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
    */
    public void editarReparacion(Reparacion reparacion) {
        reparacionDAO.editarReparacion(reparacion);
    }

    public void eliminarReparacion(int idReparacion) throws SQLException {
        
        boolean autoCommitState = connection.getAutoCommit(); 
        connection.setAutoCommit(false);
        
        List<Repuesto> listaRepuestosEliminar = repuestoDAO.obtenerRepuestosPorIdReparacion(idReparacion);
        
        try {
            ReparacionRepuestoDAO.eliminarReparacionRepuestoPorReparacion(idReparacion);
            
            reparacionDAO.eliminarReparacion(idReparacion);
            
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
        
        reparacionDAO.eliminarReparacion(idReparacion);
    }

    public Precio obtenerPrecioRepuestoPorFechaReparacion(int idReparacion, Repuesto repuesto) {
        
        Reparacion reparacion = reparacionDAO.obtenerReparacion(idReparacion);
        List<Precio> listaPrecios = repuesto.getListaPrecios();
        Precio precioActualizado = listaPrecios.stream()
        .filter(precio -> !precio.getFechaPrecio().isAfter(reparacion.getFecha_ingreso())) // Filtra precios anteriores o iguales a la fecha de venta
        .max(Comparator.comparing(Precio::getFechaPrecio))              // Encuentra el precio con la fecha más reciente
        .orElse(null); // Maneja el caso si no hay precio válido
 
        return precioActualizado;
    }
    
    
}

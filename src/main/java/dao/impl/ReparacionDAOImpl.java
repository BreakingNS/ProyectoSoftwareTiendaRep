package dao.impl;

import dao.interfaces.ReparacionDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Cliente;
import model.Estado;
import model.Factura;
import model.Marca;
import model.Modelo;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Tecnico;
import model.Ubicacion;

public class ReparacionDAOImpl implements ReparacionDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPARACION =
            "DELETE FROM TiendaLocal.reparacion WHERE id_reparacion = ?";
    private final String SENTENCIA_OBTENER_REPARACIONES =
            "SELECT * FROM TiendaLocal.reparacion ORDER BY id_reparacion ASC";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_FECHA_ACTUAL =
            "SELECT * FROM TiendaLocal.reparacion ORDER BY fecha_ingreso DESC";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_ID_CLIENTE =
            "SELECT * FROM TiendaLocal.reparacion WHERE id_cliente = ?";
    private final String SENTENCIA_OBTENER_REPARACIONES_POR_ID_CATEGORIA =
            "SELECT * FROM TiendaLocal.reparacion WHERE id_categoria = ?";
    private final String SENTENCIA_OBTENER_REPARACION =
            "SELECT * FROM TiendaLocal.reparacion WHERE id_reparacion = ?";
    private final String SENTENCIA_CREAR_REPARACION =
            "INSERT INTO TiendaLocal.reparacion (costo, detalles, fecha_ingreso, fecha_devolucion, id_factura, id_categoria, id_cliente, id_estado, id_tecnico) VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPARACION =
            "UPDATE TiendaLocal.reparacion SET costo = ?, detalles = ?, fecha_ingreso = ?, fecha_devolucion = ?, id_factura = ?, id_categoria = ?, id_cliente = ?, id_estado = ?, id_tecnico = ? WHERE id_reparacion = ?";
    private final String SENTENCIA_ACTUALIZAR_SOLO_ESTADO =
            "UPDATE TiendaLocal.reparacion SET id_estado = ? WHERE id_reparacion = ?";
    private final String SENTENCIA_ACTUALIZAR_SOLO_TECNICO =
            "UPDATE TiendaLocal.reparacion SET id_tecnico = ? WHERE id_reparacion = ?";
    private final String SENTENCIA_BUSQUEDA_DE_REPARACION =
            "SELECT r.id_reparacion, "
                + "r.costo, "
                + "r.detalles, "
                + "r.fecha_ingreso, "
                + "r.fecha_devolucion, "
                + "r.id_factura, "
                + "r.id_categoria, "
                + "r.id_estado, "
                + "r.id_tecnico, "
                + "r.id_cliente "
            + "FROM TiendaLocal.reparacion r "
            + "INNER JOIN TiendaLocal.cliente c ON r.id_cliente = c.id_cliente "
            + "WHERE (r.id_categoria = ? OR ? = 0) "
            + "AND (r.id_estado = ? OR ? = 0) "
            + "AND (r.id_tecnico = ? OR ? = 0) "
            + "AND (r.id_cliente = ? OR ? = 0) "
            + "ORDER BY r.fecha_ingreso ASC";

    public ReparacionDAOImpl(Connection connection) {
        this.connection = connection;
    }
    
    @Override
    public List<Reparacion> busquedaDeReparaciones(Reparacion reparacion) {
        
        List<Reparacion> listaReparaciones = new ArrayList<>();
        ResultSet reparacion_Resultado = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_BUSQUEDA_DE_REPARACION);

            preparedStatement.setInt(1, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(2, reparacion.getCategoria().getId_categoria());
            
            preparedStatement.setInt(3, reparacion.getEstado().getId_estado());
            preparedStatement.setInt(4, reparacion.getEstado().getId_estado());
            
            preparedStatement.setInt(5, reparacion.getTecnico().getId_tecnico());
            preparedStatement.setInt(6, reparacion.getTecnico().getId_tecnico());
            
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(8, reparacion.getCliente().getId_cliente());

            reparacion_Resultado = preparedStatement.executeQuery();
            
            while (reparacion_Resultado.next()) {
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                }
                
                int id_factura = reparacion_Resultado.getInt("id_factura");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                int id_tecnico = reparacion_Resultado.getInt("id_tecnico");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                TecnicoDAOImpl tecnicoDAO = new TecnicoDAOImpl(connection);
                
                Factura factura = facturaDAO.obtenerFactura(id_factura);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_categoria);
                //Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                Tecnico tecnico = tecnicoDAO.obtenerTecnico(id_tecnico);
                
                Reparacion reparacionNuevo = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, factura, categoria, cliente, estado, tecnico);
                /*
                System.out.println("--------------------------");
                System.out.println("id rep: " + reparacionNuevo.getId_reparacion());
                System.out.println("costo: " + reparacionNuevo.getCosto());
                System.out.println("detalles: " + reparacionNuevo.getDetalles());
                System.out.println("fecha ing: " + reparacionNuevo.getFecha_ingreso());
                System.out.println("fecha dev: " + reparacionNuevo.getFecha_devolucion());
                System.out.println("factura: " + reparacionNuevo.getFactura().getId_factura());
                System.out.println("categoria (PREVIO A LA CARGA): " + categoria.getNombre_categoria());
                System.out.println("categoria: " + reparacionNuevo.getCategoria().getNombre_categoria());
                System.out.println("cliente: " + reparacionNuevo.getCliente().getNombre().concat(" " + reparacionNuevo.getCliente().getApellido()));
                System.out.println("estado: " + reparacionNuevo.getEstado().getNombre_estado());*/
                //System.out.println("tecnico: " + reparacion.getTecnico().getNombre_tecnico().concat(" " + reparacion.getTecnico().getApellido_tecnico()));
                
                listaReparaciones.add(reparacionNuevo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        //System.out.println("tamaño de lista de busqueda DAOIMPL: " + listaRepuesto.size());
        
        return listaReparaciones;
    }
    
    @Override
    public void crearReparacion(Reparacion reparacion) {
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reparacion.getFecha_ingreso()));
            
            if(reparacion.getFecha_devolucion().equals(LocalDateTime.of(1900, 1, 1, 0, 0))){
                preparedStatement.setNull(4, java.sql.Types.TIMESTAMP);
            }
            else{
                preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(reparacion.getFecha_devolucion()));
            }   
            
            preparedStatement.setInt(5, reparacion.getFactura().getId_factura());
            preparedStatement.setInt(6, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            if(reparacion.getTecnico().getId_tecnico()==0){
                preparedStatement.setNull(9, java.sql.Types.INTEGER);
            }
            else{
                preparedStatement.setInt(9, reparacion.getTecnico().getId_tecnico());
            }
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @Override
    public List<Reparacion> obtenerReparaciones() {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES);
            ResultSet reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                }
                
                int id_factura = reparacion_Resultado.getInt("id_factura");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                int id_tecnico = reparacion_Resultado.getInt("id_tecnico");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                TecnicoDAOImpl tecnicoDAO = new TecnicoDAOImpl(connection);
                
                Factura factura = facturaDAO.obtenerFactura(id_factura);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_categoria);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                Tecnico tecnico = tecnicoDAO.obtenerTecnico(id_tecnico);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, factura, categoria, cliente, estado, tecnico);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }

    @Override
    public void actualizarReparacionSoloEstado(Reparacion reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_SOLO_ESTADO);
            preparedStatement.setInt(1, reparacion.getEstado().getId_estado());
            preparedStatement.setInt(2, reparacion.getId_reparacion());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Reparacion repaAuxiliar = obtenerReparacion(reparacion.getId_reparacion());
    }

    @Override
    public void eliminarReparacion(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPARACION);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Reparacion obtenerReparacion(int id) {
        Reparacion reparacion = null;
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACION);
            preparedStatement.setInt(1, id);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            if(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                }
                
                int id_factura = reparacion_Resultado.getInt("id_factura");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                int id_tecnico = reparacion_Resultado.getInt("id_tecnico");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                TecnicoDAOImpl tecnicoDAO = new TecnicoDAOImpl(connection);
                
                Factura factura = facturaDAO.obtenerFactura(id_factura);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_categoria);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                Tecnico tecnico = tecnicoDAO.obtenerTecnico(id_tecnico);
                reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, factura, categoria, cliente, estado, tecnico);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return reparacion;
    }

    @Override
    public List<Reparacion> obtenerReparacionesPorIdCliente(int id) {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_ID_CLIENTE);
            preparedStatement.setInt(1, id);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                }
                
                int id_factura = reparacion_Resultado.getInt("id_factura");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                int id_tecnico = reparacion_Resultado.getInt("id_tecnico");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                TecnicoDAOImpl tecnicoDAO = new TecnicoDAOImpl(connection);
                
                Factura factura = facturaDAO.obtenerFactura(id_factura);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_estado);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                Tecnico tecnico = tecnicoDAO.obtenerTecnico(id_tecnico);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, factura, categoria, cliente, estado, tecnico);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }

    @Override
    public List<Reparacion> obtenerReparacionesPorIdCategoria(int id) {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_ID_CATEGORIA);
            preparedStatement.setInt(1, id);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                }
                
                int id_factura = reparacion_Resultado.getInt("id_factura");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                int id_tecnico = reparacion_Resultado.getInt("id_tecnico");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                TecnicoDAOImpl tecnicoDAO = new TecnicoDAOImpl(connection);
                
                Factura factura = facturaDAO.obtenerFactura(id_factura);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_estado);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                Tecnico tecnico = tecnicoDAO.obtenerTecnico(id_tecnico);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, factura, categoria, cliente, estado, tecnico);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }

    @Override
    public List<Reparacion> obtenerReparacionesOrdenadasPorFechaActual() {
        List<Reparacion> listaReparaciones = new ArrayList<>();
        ResultSet reparacion_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPARACIONES_POR_FECHA_ACTUAL);
            reparacion_Resultado = preparedStatement.executeQuery();
            
            while(reparacion_Resultado.next()){
                BigDecimal costo = reparacion_Resultado.getBigDecimal("costo");
                String detalles = reparacion_Resultado.getString("detalles");
                
                Timestamp fecha = reparacion_Resultado.getTimestamp("fecha_ingreso");
                LocalDateTime fecha_ingreso = fecha.toLocalDateTime();
                fecha = reparacion_Resultado.getTimestamp("fecha_devolucion");
                
                LocalDateTime fecha_devolucion;
                if (fecha != null) {
                    fecha_devolucion = fecha.toLocalDateTime();
                } else {
                    // Manejar el caso donde fecha es null
                    fecha_devolucion = null;
                }
                
                int id_factura = reparacion_Resultado.getInt("id_factura");
                int id_reparacion = reparacion_Resultado.getInt("id_reparacion");
                int id_categoria = reparacion_Resultado.getInt("id_categoria");
                int id_cliente = reparacion_Resultado.getInt("id_cliente");
                int id_estado = reparacion_Resultado.getInt("id_estado");
                int id_tecnico = reparacion_Resultado.getInt("id_tecnico");
                
                FacturaDAOImpl facturaDAO = new FacturaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                ClienteDAOImpl clienteDAO = new ClienteDAOImpl(connection);
                EstadoDAOImpl estadoDAO = new EstadoDAOImpl(connection);
                TecnicoDAOImpl tecnicoDAO = new TecnicoDAOImpl(connection);
                
                Factura factura = facturaDAO.obtenerFactura(id_factura);
                Categoria categoria = categoriaDAO.obtenerCategoria(id_categoria);
                Cliente cliente = clienteDAO.obtenerCliente(id_cliente);
                Estado estado = estadoDAO.obtenerEstado(id_estado);
                Tecnico tecnico = tecnicoDAO.obtenerTecnico(id_tecnico);
                
                Reparacion reparacion = new Reparacion(id_reparacion, costo, detalles, fecha_ingreso, fecha_devolucion, factura, categoria, cliente, estado, tecnico);
                
                listaReparaciones.add(reparacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaReparaciones;
    }

    @Override
    public void actualizarReparacionSoloTecnico(Reparacion reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_SOLO_TECNICO);
            if(reparacion.getTecnico().getId_tecnico()==0){
                preparedStatement.setNull(1, java.sql.Types.INTEGER);
            }
            else{
                preparedStatement.setInt(1, reparacion.getTecnico().getId_tecnico());
            }
            preparedStatement.setInt(2, reparacion.getId_reparacion());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        Reparacion repaAuxiliar = obtenerReparacion(reparacion.getId_reparacion());
        
    }

    @Override
    public void actualizarReparacionCompleto(Reparacion reparacion) {
        /*
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reparacion.getFecha_ingreso()));
            preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(reparacion.getFecha_devolucion()));
            preparedStatement.setInt(5, reparacion.getFactura().getId_factura());
            preparedStatement.setInt(6, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            preparedStatement.setInt(9, reparacion.getTecnico().getId_tecnico());
            preparedStatement.setInt(10, reparacion.getId_reparacion());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reparacion.getFecha_ingreso()));
            
            if(reparacion.getFecha_devolucion().equals(LocalDateTime.of(1900, 1, 1, 0, 0))){
                preparedStatement.setNull(4, java.sql.Types.TIMESTAMP);
            }
            else{
                preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(reparacion.getFecha_devolucion()));
            }   
            //System.out.println("Factura: " + reparacion.getFactura().getId_factura());
            preparedStatement.setInt(5, reparacion.getFactura().getId_factura());
            preparedStatement.setInt(6, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            if(reparacion.getTecnico().getId_tecnico()==0){
                preparedStatement.setNull(9, java.sql.Types.INTEGER);
            }
            else{
                preparedStatement.setInt(9, reparacion.getTecnico().getId_tecnico());
            }
            preparedStatement.setInt(10, reparacion.getId_reparacion());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void editarReparacion(Reparacion reparacion) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPARACION);
            preparedStatement.setBigDecimal(1, reparacion.getCosto());
            preparedStatement.setString(2, reparacion.getDetalles());
            preparedStatement.setTimestamp(3, java.sql.Timestamp.valueOf(reparacion.getFecha_ingreso()));
            
            if(reparacion.getFecha_devolucion().equals(LocalDateTime.of(1900, 1, 1, 0, 0))){
                preparedStatement.setNull(4, java.sql.Types.TIMESTAMP);
            }
            else{
                preparedStatement.setTimestamp(4, java.sql.Timestamp.valueOf(reparacion.getFecha_devolucion()));
            }   
            //System.out.println("Factura: " + reparacion.getFactura().getId_factura());
            preparedStatement.setInt(5, reparacion.getFactura().getId_factura());
            preparedStatement.setInt(6, reparacion.getCategoria().getId_categoria());
            preparedStatement.setInt(7, reparacion.getCliente().getId_cliente());
            preparedStatement.setInt(8, reparacion.getEstado().getId_estado());
            if(reparacion.getTecnico().getId_tecnico()==0){
                preparedStatement.setNull(9, java.sql.Types.INTEGER);
            }
            else{
                preparedStatement.setInt(9, reparacion.getTecnico().getId_tecnico());
            }
            preparedStatement.setInt(10, reparacion.getId_reparacion());
            
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ReparacionDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}

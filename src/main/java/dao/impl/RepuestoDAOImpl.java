package dao.impl;

import dao.interfaces.RepuestoDAO;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Categoria;
import model.Repuesto;
import model.Marca;
import model.NombreRepuesto;
import model.Precio;
import model.Reparacion;
import model.Repuesto;
import model.Ubicacion;
import model.Venta;

public class RepuestoDAOImpl implements RepuestoDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_REPUESTO = 
            "DELETE FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    private final String SENTENCIA_OBTENER_REPUESTOS = 
            "SELECT * FROM TiendaLocal.repuesto ORDER BY id_repuesto ASC";
    private final String SENTENCIA_OBTENER_REPUESTO = 
            "SELECT * FROM TiendaLocal.repuesto WHERE id_repuesto = ?";
    
    
    private final String SENTENCIA_BUSQUEDA_DE_REPUESTO = 
            "SELECT r.* " +
            "FROM TiendaLocal.repuesto r " +
            "JOIN TiendaLocal.nombre_repuesto nr ON r.id_nombre_repuesto = nr.id " +
            "JOIN TiendaLocal.marca m ON r.id_marca = m.id " +
            "JOIN TiendaLocal.categoria c ON r.id_categoria = c.id " +
            "JOIN TiendaLocal.ubicacion u ON r.id_ubicacion = u.id " +
            "WHERE UPPER(nr.nombre) LIKE ? " +
            "AND UPPER(m.marca) LIKE ? " +
            "AND UPPER(c.categoria) LIKE ? " +
            "AND UPPER(u.ubicacion) LIKE ? " +
            "AND CAST(r.stock AS VARCHAR) LIKE ? " +
            "AND CAST(r.precio AS VARCHAR) LIKE ? ";

    
    
    private final String SENTENCIA_CREAR_REPUESTO = 
            "INSERT INTO TiendaLocal.repuesto (stock, id_nombrerepuesto, id_marca, id_categoria, id_ubicacion) VALUES ( ? , ? , ? , ? , ? )";
    private final String SENTENCIA_ACTUALIZAR_REPUESTO = 
            "UPDATE TiendaLocal.repuesto SET stock = ?, id_nombrerepuesto = ?, id_marca = ?, id_categoria = ?, id_ubicacion = ? WHERE id_repuesto = ?";

    public RepuestoDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearRepuesto(Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_REPUESTO);
            preparedStatement.setInt(1, repuesto.getStock());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(5, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public List<Repuesto> obtenerRepuestos() {
        List<Repuesto> listaRepuestos = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTOS);
            ResultSet repuesto_Resultado = preparedStatement.executeQuery();
            
            while(repuesto_Resultado.next()){
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stock = repuesto_Resultado.getInt("stock");
                int idNombreRepuesto = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarca = repuesto_Resultado.getInt("id_marca");
                int idCategoria = repuesto_Resultado.getInt("id_categoria");
                int idUbicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuesto);
                Marca marca = marcaDAO.obtenerMarca(idMarca);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoria);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacion);
                
                Repuesto repuesto = new Repuesto(idRepuesto, stock, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
                
                listaRepuestos.add(repuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return listaRepuestos;
    }
    
    @Override
    public List<Repuesto> buscarRepuesto(String nombreRepuesto, String marca, String categoria, String ubicacion, String stock, String precio) {
        List<Repuesto> listaRepuesto = new ArrayList<>();
        ResultSet repuesto_Resultado = null;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_BUSQUEDA_DE_REPUESTO);

            // Usa '%' para envolver los parámetros de búsqueda
            preparedStatement.setString(1, "%" + nombreRepuesto.toUpperCase() + "%");
            preparedStatement.setString(2, "%" + marca.toUpperCase() + "%");
            preparedStatement.setString(3, "%" + categoria.toUpperCase() + "%");
            preparedStatement.setString(4, "%" + ubicacion.toUpperCase() + "%");
            preparedStatement.setString(5, "%" + stock + "%");
            preparedStatement.setString(6, "%" + precio + "%");

            repuesto_Resultado = preparedStatement.executeQuery();

            while (repuesto_Resultado.next()) {
                // Extraer datos de cada columna necesaria y crear objetos relacionados
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stockRepuesto = repuesto_Resultado.getInt("stock");
                // Aquí extrae las relaciones con las otras tablas según sea necesario

                // Crear objetos asociados (NombreRepuesto, Marca, etc.) con los datos obtenidos
                // y armar el objeto Repuesto con ellos
                NombreRepuesto nombreRepuestoAux = new NombreRepuesto(idRepuesto, nombreRepuesto);
                Marca marcaAux = new Marca(idRepuesto, marca, new ArrayList<>());
                Categoria categoriaAux = new Categoria(idRepuesto, categoria, new ArrayList<>(), new ArrayList<>());
                Ubicacion ubicacionAux = new Ubicacion(idRepuesto, ubicacion, new ArrayList<>());

                // Agrega los objetos adicionales necesarios
                List<Precio> listaPrecios = new ArrayList<>();
                Precio precioAux = new Precio(idRepuesto, null, null, new BigDecimal(precio));
                listaPrecios.add(precioAux);

                Repuesto repuesto = new Repuesto(idRepuesto, stockRepuesto, nombreRepuestoAux, marcaAux, categoriaAux, listaPrecios, ubicacionAux);

                listaRepuesto.add(repuesto);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaRepuesto;
    }


    @Override
    public void actualizarRepuesto(Repuesto repuesto) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_REPUESTO);
            preparedStatement.setInt(1, repuesto.getStock());
            preparedStatement.setInt(2, repuesto.getNombreRepuesto().getId_nombrerepuesto());
            preparedStatement.setInt(3, repuesto.getMarca().getId_marca());
            preparedStatement.setInt(4, repuesto.getCategoria().getId_categoria());
            preparedStatement.setInt(5, repuesto.getUbicacion().getId_ubicacion());
            preparedStatement.setInt(6, repuesto.getId_repuesto());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarRepuesto(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_REPUESTO);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @Override
    public Repuesto obtenerRepuesto(int id) {
        Repuesto repuesto = null;
        ResultSet repuesto_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_REPUESTO);
            preparedStatement.setInt(1, id);
            repuesto_Resultado = preparedStatement.executeQuery();
            
            if(repuesto_Resultado.next()){
                int idRepuesto = repuesto_Resultado.getInt("id_repuesto");
                int stock = repuesto_Resultado.getInt("stock");
                int idNombreRepuesto = repuesto_Resultado.getInt("id_nombrerepuesto");
                int idMarca = repuesto_Resultado.getInt("id_marca");
                int idCategoria = repuesto_Resultado.getInt("id_categoria");
                int idUbicacion = repuesto_Resultado.getInt("id_ubicacion");
                
                NombreRepuestoDAOImpl nombreRepuestoDAO = new NombreRepuestoDAOImpl(connection);
                MarcaDAOImpl marcaDAO = new MarcaDAOImpl(connection);
                CategoriaDAOImpl categoriaDAO = new CategoriaDAOImpl(connection);
                UbicacionDAOImpl ubicacionDAO = new UbicacionDAOImpl(connection);
                
                NombreRepuesto nombreRepuesto = nombreRepuestoDAO.obtenerNombreRepuesto(idNombreRepuesto);
                Marca marca = marcaDAO.obtenerMarca(idMarca);
                Categoria categoria = categoriaDAO.obtenerCategoria(idCategoria);
                List<Precio> listaPrecios = new ArrayList<>();
                Ubicacion ubicacion = ubicacionDAO.obtenerUbicacion(idUbicacion);
                
                repuesto = new Repuesto(idRepuesto, stock, nombreRepuesto, marca, categoria, listaPrecios, ubicacion);
            }
        } catch (SQLException ex) {
            Logger.getLogger(RepuestoDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return repuesto;
    }

}

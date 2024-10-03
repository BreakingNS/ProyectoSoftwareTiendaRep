package dao.impl;

import dao.interfaces.ClienteDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cliente;
import model.Reparacion;
import model.Venta;

public class ClienteDAOImpl implements ClienteDAO{
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_CLIENTE = "DELETE FROM TiendaLocal.cliente WHERE id_cliente = ?";
    private final String SENTENCIA_OBTENER_CLIENTES = "SELECT * FROM TiendaLocal.cliente ORDER BY id_cliente ASC";
    private final String SENTENCIA_OBTENER_CLIENTE = "SELECT * FROM TiendaLocal.cliente WHERE id_cliente = ?";
    private final String SENTENCIA_BUSQUEDA_DE_CLIENTE = 
            "SELECT * " + 
            "FROM TiendaLocal.cliente " +
            "WHERE UPPER(nombre) LIKE ? " +
            "AND UPPER(apellido) LIKE ? " +
            "AND UPPER(telefono) LIKE ? " +
            "AND UPPER(domicilio) LIKE ? ";
    private final String SENTENCIA_CREAR_CLIENTE = "INSERT INTO TiendaLocal.cliente (nombre, apellido, telefono, domicilio) VALUES ( UPPER(?) , UPPER(?) , ?, UPPER(?) )";
    private final String SENTENCIA_ACTUALIZAR_CLIENTE = "UPDATE TiendaLocal.cliente SET nombre = UPPER(?), apellido = UPPER(?), telefono = ?, domicilio = UPPER(?) WHERE id_cliente = ?";

    public ClienteDAOImpl(Connection connection) {
        this.connection = connection;
    }

    @Override
    public void crearCliente(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_CREAR_CLIENTE);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setString(4, cliente.getDomicilio());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_CLIENTES);
            ResultSet cliente_Resultado = preparedStatement.executeQuery();
            
            while(cliente_Resultado.next()){
                String nombreCliente = cliente_Resultado.getString("nombre");
                String apellidoCliente = cliente_Resultado.getString("apellido");
                String telefonoCliente = cliente_Resultado.getString("telefono");
                String domicilioCliente = cliente_Resultado.getString("domicilio");
                int idCliente = cliente_Resultado.getInt("id_cliente");
                
                List<Venta> listaVentas = new ArrayList<>();
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                Cliente cliente = new Cliente(idCliente, nombreCliente, apellidoCliente, telefonoCliente, domicilioCliente, listaVentas, listaReparaciones);
                
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    @Override
    public List<Cliente> buscarCliente(Cliente cliente) {
        List<Cliente> listaClientes = new ArrayList<>();
        ResultSet cliente_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_BUSQUEDA_DE_CLIENTE);
        
            // Usa '%' para envolver los parámetros de búsqueda
            preparedStatement.setString(1, "%" + cliente.getNombre().toUpperCase() + "%");
            preparedStatement.setString(2, "%" + cliente.getApellido().toUpperCase() + "%");
            preparedStatement.setString(3, "%" + cliente.getTelefono().toUpperCase() + "%");
            preparedStatement.setString(4, "%" + cliente.getDomicilio().toUpperCase() + "%");

            cliente_Resultado = preparedStatement.executeQuery();
            
            while(cliente_Resultado.next()){
                int idCliente = cliente_Resultado.getInt("id_cliente");
                String nombreCliente = cliente_Resultado.getString("nombre");
                String apellidoCliente = cliente_Resultado.getString("apellido");
                String telefonoCliente = cliente_Resultado.getString("telefono");
                String domicilioCliente = cliente_Resultado.getString("domicilio");
                
                List<Venta> listaVentas = new ArrayList<>();
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                cliente = new Cliente(idCliente, nombreCliente, apellidoCliente, telefonoCliente, domicilioCliente, listaVentas, listaReparaciones);
            
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaClientes;
    }
    
    @Override
    public void actualizarCliente(Cliente cliente) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_CLIENTE);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getTelefono());
            preparedStatement.setString(4, cliente.getDomicilio());
            preparedStatement.setInt(5, cliente.getId_cliente());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void eliminarCliente(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ELIMINAR_CLIENTE);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public Cliente obtenerCliente(int id) {
        Cliente cliente = null;
        ResultSet cliente_Resultado = null;
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_CLIENTE);
            preparedStatement.setInt(1, id);
            cliente_Resultado = preparedStatement.executeQuery();
            
            if(cliente_Resultado.next()){
                int idCliente = cliente_Resultado.getInt("id_cliente");
                String nombreCliente = cliente_Resultado.getString("nombre");
                String apellidoCliente = cliente_Resultado.getString("apellido");
                String telefonoCliente = cliente_Resultado.getString("telefono");
                String domicilioCliente = cliente_Resultado.getString("domicilio");
                
                List<Venta> listaVentas = new ArrayList<>();
                List<Reparacion> listaReparaciones = new ArrayList<>();
                
                cliente = new Cliente(idCliente, nombreCliente, apellidoCliente, telefonoCliente, domicilioCliente, listaVentas, listaReparaciones);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }

        return cliente;
    }
}

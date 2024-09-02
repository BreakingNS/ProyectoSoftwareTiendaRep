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
import model.Cliente;

public class ClienteDAOImpl implements ClienteDAO{
    /*
    Columnas/Campos de la Tabla Cliente
    
    id_cliente
    nombre_cliente
    */
    
    private Connection connection = null; 
    private final String SENTENCIA_ELIMINAR_CLIENTE = "DELETE FROM TiendaLocal.cliente WHERE id_cliente = ?";
    private final String SENTENCIA_OBTENER_CLIENTE = "SELECT * FROM TiendaLocal.cliente";
    private final String SENTENCIA_CREAR_CLIENTE = "INSERT INTO TiendaLocal.cliente (nombre, apellido, telefono) VALUES ( ? , ? , ?)";
    private final String SENTENCIA_ACTUALIZAR_CLIENTE = "UPDATE TiendaLocal.cliente SET nombre = ?, apellido = ?, telefono = ? WHERE id_cliente = ?";

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
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Cliente> obtenerClientes() {
        List<Cliente> listaClientes = new ArrayList<>();
        
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_OBTENER_CLIENTE);
            ResultSet cliente_Resultado = preparedStatement.executeQuery();
            
            while(cliente_Resultado.next()){
                String nombreCliente = cliente_Resultado.getString("nombre");
                String apellidoCliente = cliente_Resultado.getString("apellido");
                String telefonoCliente = cliente_Resultado.getString("telefono");
                int idCliente = cliente_Resultado.getInt("id_cliente");
                
                Cliente cliente = new Cliente(idCliente, nombreCliente, apellidoCliente, telefonoCliente);
                
                listaClientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAOImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaClientes;
    }

    @Override
    public void actualizarCliente(Cliente cliente, int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SENTENCIA_ACTUALIZAR_CLIENTE);
            preparedStatement.setString(1, cliente.getNombre());
            preparedStatement.setString(2, cliente.getApellido());
            preparedStatement.setString(3, cliente.getTelefono());
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
    public void toStringCliente() {
        List<Cliente> listaClientes = obtenerClientes();
        
        for(Cliente clien : listaClientes){
            System.out.println("------------------");
            System.out.println("Id: " + clien.getId_cliente());
            System.out.println("Nombre: " + clien.getNombre());
            System.out.println("Apellido: " + clien.getApellido());
            System.out.println("Telefono: " + clien.getTelefono());
        }
    }
}

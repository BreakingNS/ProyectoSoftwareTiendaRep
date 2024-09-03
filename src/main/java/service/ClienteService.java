package service;

import dao.interfaces.ClienteDAO;
import java.util.List;
import model.Cliente;

public class ClienteService {
    private final ClienteDAO clienteDAO;
    
    public ClienteService(ClienteDAO clienteDAO){
        this.clienteDAO = clienteDAO;
    }
    
    public void agregarCliente(Cliente cliente){
        clienteDAO.crearCliente(cliente);
    }
    
    public List<Cliente> listarClientes() {
        return clienteDAO.obtenerClientes();
    }
    
    public Cliente obtenerClientePorId(int id) {
        // Lógica adicional si es necesario
        return clienteDAO.obtenerCliente(id);
    }
    
    public void editarClientePorId(Cliente cliente){
        clienteDAO.actualizarCliente(cliente);
    }
    
    public void eliminarClientePorId(int id){
        clienteDAO.eliminarCliente(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirClientes() {
        List<Cliente> listaClientes = listarClientes(); // Usando el método para obtener categorías
        
        for(Cliente clien : listaClientes){
            System.out.println("------------------");
            System.out.println("Id: " + clien.getId_cliente());
            System.out.println("Nombre: " + clien.getNombre());
            System.out.println("Apellido: " + clien.getApellido());
            System.out.println("Telefono: " + clien.getTelefono());
        }
    }
    
    public Boolean existeCliente(Cliente cliente){
        List<Cliente> listaClientes = listarClientes();
        boolean existeCliente = false;
        
        for(Cliente cli : listaClientes){
            if(cli.getApellido().equals(cliente.getApellido()) && (cli.getNombre().equals(cliente.getNombre()))){
                existeCliente = true;
                break;
            }
        }
        return existeCliente;
    }
    
    public Boolean existeTelefonoCliente(Cliente cliente){
        List<Cliente> listaClientes = listarClientes();
        boolean existeTelefono = false;
        
        for(Cliente cli : listaClientes){
            if(cli.getTelefono().equals(cliente.getTelefono())){
                existeTelefono = true;
                break;
            }
        }
        return existeTelefono;
    }
    
    //Reportes Clientes
}

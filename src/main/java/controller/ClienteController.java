package controller;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import service.ClienteService;

public class ClienteController {
    
    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService;
    }
    
    public void agregarCliente(String nombre, String apellido, String telefono, String domicilio){
        Cliente cliente = new Cliente(1, nombre, apellido, telefono, domicilio, new ArrayList<>(), new ArrayList<>());
        clienteService.agregarCliente(cliente);
    }
    
    public List<Cliente> listarClientes(){
        List<Cliente> listaClientes= clienteService.listarClientes();
        return listaClientes;
    }
    
    public Cliente obtenerClientePorId(int id){
        Cliente cliente = clienteService.obtenerClientePorId(id);
        return cliente;
    }
    
    public List<Cliente> busquedaDeCliente(String nombre, String apellido, String telefono, String domicilio){
        Cliente cliente = new Cliente(0, nombre, apellido, telefono, domicilio, new ArrayList<>(), new ArrayList<>());
        List<Cliente> listaClientes = clienteService.busquedaDeCliente(cliente);
        
        return listaClientes;
    }
    
    public void editarCliente(int id, String nombre, String apellido, String telefono, String domicilio){
        Cliente cliente = new Cliente(id, nombre, apellido, telefono, domicilio, new ArrayList<>(), new ArrayList<>());
        clienteService.editarClientePorId(cliente);
    }
    
    public void eliminarCliente(int id){
        clienteService.eliminarClientePorId(id);
    }
    
}

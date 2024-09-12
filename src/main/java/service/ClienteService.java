package service;

import dao.interfaces.ClienteDAO;
import dao.interfaces.ReparacionDAO;
import dao.interfaces.VentaDAO;
import java.util.List;
import model.Cliente;
import model.Reparacion;
import model.Venta;

public class ClienteService {
    private final ClienteDAO clienteDAO;
    private final VentaDAO ventaDAO;
    private final ReparacionDAO reparacionDAO;
    
    public ClienteService(ClienteDAO clienteDAO, VentaDAO ventaDAO, ReparacionDAO reparacionDAO){
        this.clienteDAO = clienteDAO;
        this.ventaDAO = ventaDAO;
        this.reparacionDAO = reparacionDAO;
    }
    
    public void agregarCliente(Cliente cliente){
        clienteDAO.crearCliente(cliente);
    }
    
    public List<Cliente> listarClientes() {
        List<Cliente> listaClientes = clienteDAO.obtenerClientes();
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Cliente cli : listaClientes){
            for(Reparacion rep : listaReparacionesAuxiliar){
                if(rep.getCliente().getId_cliente() == (cli.getId_cliente())){
                    cli.getListaReparaciones().add(rep);
                }
            }
        }
        
        List<Venta> listaVentasAuxiliar = ventaDAO.obtenerVentas();
        for(Cliente cli : listaClientes){
            for(Venta ven : listaVentasAuxiliar){
                if(ven.getCliente().getId_cliente() == (cli.getId_cliente())){
                    cli.getListaVentas().add(ven);
                }
            }
        }
        
        return listaClientes;
    }
    
    public Cliente obtenerClientePorId(int id) {
        Cliente cliente = clienteDAO.obtenerCliente(id);
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Reparacion rep : listaReparacionesAuxiliar){
            if(rep.getCliente().getId_cliente() == (cliente.getId_cliente())){
                cliente.getListaReparaciones().add(rep);
            }
        }
        
        
        List<Venta> listaVentasAuxiliar = ventaDAO.obtenerVentas();
        for(Venta ven : listaVentasAuxiliar){
            if(ven.getCliente().getId_cliente() == (cliente.getId_cliente())){
                cliente.getListaVentas().add(ven);
            }
        }
        
        return cliente;
    }
    
    public List<Cliente> busquedaDeCliente(Cliente cliente){
        List<Cliente> listaCliente = clienteDAO.buscarCliente(cliente);
        return listaCliente;
    }
    
    public void editarClientePorId(Cliente cliente){
        clienteDAO.actualizarCliente(cliente);
    }
    
    public void eliminarClientePorId(int id){
        clienteDAO.eliminarCliente(id);
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

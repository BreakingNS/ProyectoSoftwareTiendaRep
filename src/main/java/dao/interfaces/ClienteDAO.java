package dao.interfaces;

import java.util.List;
import model.Cliente;

public interface ClienteDAO {
    public void crearCliente(Cliente cliente);
    public List<Cliente> obtenerClientes();
    public Cliente obtenerCliente(int id);
    public List<Cliente> buscarCliente(Cliente cliente);
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(int id);
    public Cliente obtenerClientePorNombre(String nombreEncontrado, String apellidoEncontrado);
}

package dao.interfaces;

import java.util.List;
import model.Cliente;

public interface ClienteDAO {
    public void crearCliente(Cliente cliente);
    public List<Cliente> obtenerClientes();
    public void actualizarCliente(Cliente cliente, int id);
    public void eliminarCliente(int id);
    public void toStringCliente();
}

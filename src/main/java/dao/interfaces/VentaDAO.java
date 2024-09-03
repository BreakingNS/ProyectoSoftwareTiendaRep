package dao.interfaces;

import java.util.List;
import model.Venta;

public interface VentaDAO {
    public void crearVenta(Venta venta);
    public List<Venta> obtenerVentas();
    public List<Venta> obtenerVentasPorIdCliente(int id);
    public Venta obtenerVenta(int id);
    public void actualizarVenta(Venta venta);
    public void eliminarVenta(int id);
}

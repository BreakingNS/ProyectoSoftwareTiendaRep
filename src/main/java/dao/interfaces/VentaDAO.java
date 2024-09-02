package dao.interfaces;

import java.util.List;
import model.Venta;

public interface VentaDAO {
    public void crearVenta(Venta venta);
    public List<Venta> obtenerVentas();
    public void actualizarVenta(Venta venta, int id);
    public void eliminarVenta(int id);
    public void toStringVenta();
}

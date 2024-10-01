package dao.interfaces;

import java.util.List;
import model.Factura;

public interface FacturaDAO {
    public void crearFactura(Factura factura);
    public List<Factura> obtenerFacturas();
    public Factura obtenerFactura(int id);
    public void actualizarFactura(Factura factura);
    public void eliminarFactura(int id);
}

package dao.interfaces;

import java.util.List;
import model.Pago;
import model.Pago;

public interface PagoDAO {
    public void crearPago(Pago pago);
    public List<Pago> obtenerPagos();
    public Pago obtenerPago(int id);
    public void actualizarPago(Pago pago);
    public void eliminarPago(int id);
}

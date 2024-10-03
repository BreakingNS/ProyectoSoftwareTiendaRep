package service;

import dao.interfaces.PagoDAO;
import java.util.List;
import model.Pago;

public class PagoService {
    private final PagoDAO pagoDAO;

    public PagoService(PagoDAO pagoDAO) {
        this.pagoDAO = pagoDAO;
    }
    
    public void agregarPago(Pago pago){
        pagoDAO.crearPago(pago);
    }
    
    public List<Pago> listarPagos() {
        return pagoDAO.obtenerPagos();
    }
    
    public Pago obtenerPagoPorId(int id) {
        return pagoDAO.obtenerPago(id);
    }
    
    public void editarPagoPorId(Pago pago){        
        pagoDAO.actualizarPago(pago);
    }
    
    public void eliminarPagoPorId(int id){
        pagoDAO.eliminarPago(id);
    }

    public List<Pago> obtenerPagosPorIdFactura(int id_factura) {
        return pagoDAO.obtenerPagosPorIdFactura(id_factura);
    }
}

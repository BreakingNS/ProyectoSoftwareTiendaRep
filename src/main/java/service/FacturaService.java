package service;

import dao.interfaces.FacturaDAO;
import java.util.List;
import model.Factura;

public class FacturaService {
    private final FacturaDAO facturaDAO;

    public FacturaService(FacturaDAO facturaDAO) {
        this.facturaDAO = facturaDAO;
    }
    
    public void agregarFactura(Factura factura){
        facturaDAO.crearFactura(factura);
    }
    
    public List<Factura> listarFacturas() {
        return facturaDAO.obtenerFacturas();
    }
    
    public Factura obtenerFacturaPorId(int id) {
        return facturaDAO.obtenerFactura(id);
    }
    
    public void editarFacturaPorId(Factura factura){        
        facturaDAO.actualizarFactura(factura);
    }
    
    public void eliminarFacturaPorId(int id){
        facturaDAO.eliminarFactura(id);
    }
    
}

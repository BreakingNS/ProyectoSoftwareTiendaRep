package controller;

import java.math.BigDecimal;
import java.util.List;
import model.Factura;
import service.FacturaService;

public class FacturaController {
    private final FacturaService facturaService;

    public FacturaController(FacturaService facturaService) {
        this.facturaService = facturaService;
    }
    
    public void agregarFactura(String estado, BigDecimal montoTotal){
        Factura factura = new Factura(0, estado, montoTotal);
        facturaService.agregarFactura(factura);
    }
    
    public List<Factura> listarFacturas(){
        List<Factura> listaFacturas= facturaService.listarFacturas();
        return listaFacturas;
    }
    
    public Factura obtenerFacturaPorId(int id){
        Factura factura = facturaService.obtenerFacturaPorId(id);
        return factura;
    }
    /*
    public List<Factura> busquedaDeFactura(String nombre, String apellido, String telefono){
        Factura factura = new Factura(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Factura> listaFacturas = facturaService.busquedaDeFactura(factura);
        
        return listaFacturas;
    }
    */
    public void editarFactura(int id, String estado, BigDecimal montoTotal){
        Factura factura = new Factura(id, estado, montoTotal);
        facturaService.editarFacturaPorId(factura);
    }
    
    public void eliminarFactura(int id){
        facturaService.eliminarFacturaPorId(id);
    }

    public Factura obtenerUltimaFactura() {
        return facturaService.obtenerUltimaFactura(); 
    }
}

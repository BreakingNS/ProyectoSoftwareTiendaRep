package controller;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import model.Factura;
import model.Pago;
import service.PagoService;

public class PagoController {
    private final PagoService pagoService;

    public PagoController(PagoService pagoService) {
        this.pagoService = pagoService;
    }
    
    public void agregarPago(Factura factura, BigDecimal montoAbonado, LocalDateTime fechaPago, String detalle){
        Pago pago = new Pago(0, factura, montoAbonado, fechaPago, detalle);
        pagoService.agregarPago(pago);
    }
    
    public List<Pago> listarPagosOrdenado(){
        List<Pago> listaPagos= pagoService.listarPagos();
        return listaPagos;
    }
    
    public Pago obtenerPagoPorId(int id){
        Pago pago = pagoService.obtenerPagoPorId(id);
        return pago;
    }
    /*
    public List<Pago> busquedaDePago(String nombre, String apellido, String telefono){
        Pago pago = new Pago(0, nombre, apellido, telefono, new ArrayList<>(), new ArrayList<>());
        List<Pago> listaPagos = pagoService.busquedaDePago(pago);
        
        return listaPagos;
    }
    */
    public void editarPago(int id, Factura factura, BigDecimal montoAbonado, LocalDateTime fechaPago, String detalle){
        Pago pago = new Pago(id, factura, montoAbonado, fechaPago, detalle);
        pagoService.editarPagoPorId(pago);
    }
    
    public void eliminarPago(int id){
        pagoService.eliminarPagoPorId(id);
    }

    public List<Pago> obtenerPagosPorIdFactura(int id_factura) {
        return pagoService.obtenerPagosPorIdFactura(id_factura);
    }
}

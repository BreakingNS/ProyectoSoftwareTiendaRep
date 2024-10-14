package service;

import dao.interfaces.PagoDAO;
import java.util.ArrayList;
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
    
    public List<String> listarPagos() {
        List<String> listaPagos = new ArrayList<>();
        
        listaPagos.add("NO");
        listaPagos.add("PARCIAL");
        listaPagos.add("SI");
        
        return listaPagos;
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
    
    public String obtenerPagoPorNombre(String pagoSeleccionado) {
        List<String> listaPagos = listarPagos();
        String retorno = "";
        
        for(String pago : listaPagos){
            if(pago.equals("NO")){
                retorno = "NO";
            }
            else if(pago.equals("PARCIAL")){
                retorno = "PARCIAL";
            }else{
                retorno = "SI";
            }
        }
        
        return retorno;
    }
}

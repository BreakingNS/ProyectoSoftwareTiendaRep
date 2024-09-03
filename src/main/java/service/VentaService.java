package service;

import dao.interfaces.VentaDAO;
import java.util.List;
import model.Venta;

public class VentaService {
    private final VentaDAO ventaDAO;

    public VentaService(VentaDAO ventaDAO) {
        this.ventaDAO = ventaDAO;
    }
    
    public void agregarVenta(Venta venta){
        ventaDAO.crearVenta(venta);
    }
    
    public List<Venta> listarVentas() {
        return ventaDAO.obtenerVentas();
    }
    
    public Venta obtenerVentaPorId(int id) {
        // Lógica adicional si es necesario
        return ventaDAO.obtenerVenta(id);
    }
    
    public void editarVentaPorId(Venta venta){
        ventaDAO.actualizarVenta(venta);
    }
    
    public void eliminarVentaPorId(int id){
        ventaDAO.eliminarVenta(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirVentas() {
        List<Venta> listaVentas = listarVentas();
        
        for(Venta ven : listaVentas){
            System.out.println("------------------");
            System.out.println("Id: " + ven.getId_venta());
            System.out.println("Cantidad: " + ven.getCantidad());
            System.out.println("Fecha Venta: " + ven.getFecha_venta());
            System.out.println("Cliente: " + ven.getCliente().getId_cliente());
        }
    }
}

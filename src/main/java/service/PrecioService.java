package service;

import dao.interfaces.PrecioDAO;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDateTime;
import java.util.List;
import model.Precio;
import model.Repuesto;

public class PrecioService {
    private final PrecioDAO precioDAO;

    public PrecioService(PrecioDAO precioDAO) {
        this.precioDAO = precioDAO;
    }
    
    public void agregarPrecio(Precio precio){
        precioDAO.crearPrecio(precio);
    }
    
    public List<Precio> listarPrecios() {
        return precioDAO.obtenerPrecios();
    }
    
    public Precio obtenerPrecioPorId(int id) {
        // Lógica adicional si es necesario
        return precioDAO.obtenerPrecio(id);
    }
    
    public List<Precio> obtenerPrecioPorIdProducto(int id) {
        // Lógica adicional si es necesario
        return precioDAO.obtenerPreciosPorIdRepuesto(id);
    }
    
    public void editarPrecioPorId(Precio precio){
        precioDAO.actualizarPrecio(precio);
    }
    
    public void eliminarPrecioPorId(int id){
        precioDAO.eliminarPrecio(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirPrecios() {
        List<Precio> listaPrecios = listarPrecios();
        
        for(Precio pre : listaPrecios){
            System.out.println("------------------");
            System.out.println("Id: " + pre.getId_precio());
            System.out.println("Fecha de Precio: " + pre.getFechaPrecio());
            System.out.println("Valor: " + pre.getValor());
            System.out.println("Repuesto: " + pre.getRepuesto().getNombreRepuesto());
        }
    }
    
    public void actualizarPrecioRepuesto(Repuesto repuesto, BigDecimal nuevoValor){
        LocalDateTime ahora = LocalDateTime.now();
        Date sqlDate = Date.valueOf(ahora.toLocalDate());
        
        Precio precioNuevo = new Precio();
        precioNuevo.setRepuesto(repuesto);
        precioNuevo.setFechaPrecio(sqlDate);
        precioNuevo.setValor(nuevoValor);
        
        precioDAO.crearPrecio(precioNuevo);
    }
    
    //Reportes Precios
}

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
        return precioDAO.obtenerPrecio(id);
    }
    
    public List<Precio> obtenerPrecioPorIdRepuesto(int id) {
        return precioDAO.obtenerPreciosPorIdRepuesto(id);
    }
    
    public void editarPrecioPorId(Precio precio){
        precioDAO.actualizarPrecio(precio);
    }
    
    public void eliminarPrecioPorId(int id){
        precioDAO.eliminarPrecio(id);
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
}

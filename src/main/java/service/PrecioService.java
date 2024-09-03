package service;

import dao.interfaces.PrecioDAO;
import java.util.List;
import model.Precio;

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
        }
    }
}

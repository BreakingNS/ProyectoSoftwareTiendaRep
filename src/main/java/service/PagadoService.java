package service;

import dao.interfaces.PagadoDAO;
import java.util.List;
import model.Pagado;

public class PagadoService {
    private final PagadoDAO modeloDAO;

    public PagadoService(PagadoDAO modeloDAO) {
        this.modeloDAO = modeloDAO;
    }
    
    public void agregarPagado(Pagado modelo){
        modeloDAO.crearPagado(modelo);
    }
    
    public List<Pagado> listarPagados() {
        return modeloDAO.obtenerPagados();
    }
    
    public Pagado obtenerPagadoPorId(int id) {
        return modeloDAO.obtenerPagado(id);
    }
    
    public void editarPagadoPorId(Pagado modelo){        
        modeloDAO.actualizarPagado(modelo);
    }
    
    public void eliminarPagadoPorId(int id){
        modeloDAO.eliminarPagado(id);
    }
    
    public boolean existePagado(String nombre){
        return modeloDAO.existePagado(nombre);
    }

    public Pagado obtenerPagadoPorNombre(String modelo) {
        return modeloDAO.obtenerPagadoPorNombre(modelo);
    }
}

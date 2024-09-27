package service;

import dao.interfaces.ModeloDAO;
import dao.interfaces.ModeloDAO;
import dao.interfaces.RepuestoDAO;
import java.util.List;
import model.Modelo;
import model.Modelo;
import model.Repuesto;

public class ModeloService {
    private final ModeloDAO modeloDAO;

    public ModeloService(ModeloDAO modeloDAO) {
        this.modeloDAO = modeloDAO;
    }
    
    public void agregarModelo(Modelo modelo){
        modeloDAO.crearModelo(modelo);
    }
    
    public List<Modelo> listarModelos() {
        return modeloDAO.obtenerModelos();
    }
    
    public Modelo obtenerModeloPorId(int id) {
        return modeloDAO.obtenerModelo(id);
    }
    
    public void editarModeloPorId(Modelo modelo){        
        modeloDAO.actualizarModelo(modelo);
    }
    
    public void eliminarModeloPorId(int id){
        modeloDAO.eliminarModelo(id);
    }
    
    public boolean existeModelo(String nombre){
        return modeloDAO.existeModelo(nombre);
    }

    public Modelo obtenerModeloPorNombre(String modelo) {
        return modeloDAO.obtenerModeloPorNombre(modelo);
    }
}

package service;

import dao.interfaces.NombreRepuestoDAO;
import java.util.List;
import model.NombreRepuesto;

public class NombreRepuestoService {
    private final NombreRepuestoDAO nombreRepuestoDAO;

    public NombreRepuestoService(NombreRepuestoDAO nombreRepuestoDAO) {
        this.nombreRepuestoDAO = nombreRepuestoDAO;
    }
    
    public void agregarNombreRepuesto(NombreRepuesto nombreRepuesto){
        nombreRepuestoDAO.crearNombreRepuesto(nombreRepuesto);
    }
    
    public List<NombreRepuesto> listarNombreRepuestos() {
        return nombreRepuestoDAO.obtenerNombreRepuestos();
    }
    
    public NombreRepuesto obtenerNombreRepuestoPorId(int id) {
        return nombreRepuestoDAO.obtenerNombreRepuesto(id);
    }
    
    public void editarNombreRepuestoPorId(NombreRepuesto nombreRepuesto){        
        nombreRepuestoDAO.actualizarNombreRepuesto(nombreRepuesto);
    }
    
    public void eliminarNombreRepuestoPorId(int id){
        nombreRepuestoDAO.eliminarNombreRepuesto(id);
    }
    
    public boolean existeNombreRepuesto(String nombre){
        return nombreRepuestoDAO.existeNombreRepuesto(nombre);
    }
}

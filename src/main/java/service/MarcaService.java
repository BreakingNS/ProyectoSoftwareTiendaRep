package service;

import dao.interfaces.MarcaDAO;
import java.util.List;
import model.Marca;

public class MarcaService {
    private final MarcaDAO marcaDAO;

    public MarcaService(MarcaDAO marcaDAO) {
        this.marcaDAO = marcaDAO;
    }
    
    public void agregarMarca(Marca marca){
        marcaDAO.crearMarca(marca);
    }
    
    public List<Marca> listarMarcas() {
        return marcaDAO.obtenerMarcas();
    }
    
    public Marca obtenerMarcaPorId(int id) {
        // Lógica adicional si es necesario
        return marcaDAO.obtenerMarca(id);
    }
    
    public void editarMarcaPorId(Marca marca){
        marcaDAO.actualizarMarca(marca);
    }
    
    public void eliminarMarcaPorId(int id){
        marcaDAO.eliminarMarca(id);
    }
    
    // Método para imprimir las categorías (si esto es parte de la lógica de negocio)
    public void imprimirMarcas() {
        List<Marca> listaMarcas = listarMarcas();
        
        for(Marca mar : listaMarcas){
            System.out.println("------------------");
            System.out.println("Id: " + mar.getId_marca());
            System.out.println("Nombre: " + mar.getNombre_marca());
        }
    }
}

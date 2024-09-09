package service;

import dao.interfaces.MarcaDAO;
import dao.interfaces.RepuestoDAO;
import java.util.List;
import model.Marca;
import model.Repuesto;

public class MarcaService {
    private final MarcaDAO marcaDAO;
    private final RepuestoDAO repuestoDAO;

    public MarcaService(MarcaDAO marcaDAO, RepuestoDAO repuestoDAO) {
        this.marcaDAO = marcaDAO;
        this.repuestoDAO = repuestoDAO;
    }
    
    public void agregarMarca(Marca marca){
        marcaDAO.crearMarca(marca);
    }
    
    public List<Marca> listarMarcas() {
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        List<Marca> listaMarcas = marcaDAO.obtenerMarcas();
        for(Marca mar : listaMarcas){
            for(Repuesto rep : listaRepuestosAuxiliar){
                if(rep.getMarca().getId_marca() == (mar.getId_marca())){
                    mar.getListaRepuestos().add(rep);
                }
            }
        }
        
        return listaMarcas;
    }
    
    public Marca obtenerMarcaPorId(int id) {
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        Marca marca = marcaDAO.obtenerMarca(id);
        
        for(Repuesto rep : listaRepuestosAuxiliar){
            if(rep.getMarca().getId_marca() == (marca.getId_marca())){
                marca.getListaRepuestos().add(rep);
            }
        }        
        
        return marca;
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

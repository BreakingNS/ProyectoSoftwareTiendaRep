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
    
    public List<Marca> listarMarcasOrdenadasPorNombre() {
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        List<Marca> listaMarcas = marcaDAO.obtenerMarcasOrdenadasPorNombre();
        for(Marca mar : listaMarcas){
            for(Repuesto rep : listaRepuestosAuxiliar){
                if(rep.getMarca().getId_marca() == (mar.getId_marca())){
                    mar.getListaRepuestos().add(rep);
                }
            }
        }
        
        return listaMarcas;
    }
    
    public List<Marca> listarMarcasOrdenadasPorId() {
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        List<Marca> listaMarcas = marcaDAO.obtenerMarcasOrdenadasPorId();
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
    
    public boolean existeMarca(String nombre){
        return marcaDAO.existeMarca(nombre);
    }
    
    public Marca obtenerMarcaPorNombre(String nombre){
        return marcaDAO.obtenerMarcaPorNombre(nombre);
    }

    
}

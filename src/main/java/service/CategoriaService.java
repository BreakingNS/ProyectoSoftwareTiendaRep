package service;

import dao.interfaces.CategoriaDAO;
import dao.interfaces.ReparacionDAO;
import dao.interfaces.RepuestoDAO;
import java.util.List;
import model.Categoria;
import model.Reparacion;
import model.Repuesto;

public class CategoriaService {
    private final CategoriaDAO categoriaDAO;
    private final RepuestoDAO repuestoDAO;
    private final ReparacionDAO reparacionDAO;

    public CategoriaService(CategoriaDAO categoriaDAO, RepuestoDAO repuestoDAO, ReparacionDAO reparacionDAO) {
        this.categoriaDAO = categoriaDAO;
        this.repuestoDAO = repuestoDAO;
        this.reparacionDAO = reparacionDAO;
    }
    
    public void agregarCategoria(Categoria categoria){
        categoriaDAO.crearCategoria(categoria);
    }
    
    public List<Categoria> listarCategoriasOrdenadasPorId() {
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategoriasOrdenadasPorId();
        
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        for(Categoria mar : listaCategorias){
            for(Repuesto rep : listaRepuestosAuxiliar){
                if(rep.getCategoria().getId_categoria() == (mar.getId_categoria())){
                    mar.getListaRepuestos().add(rep);
                }
            }
        }
        
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Categoria mar : listaCategorias){
            for(Reparacion rep : listaReparacionesAuxiliar){
                if(rep.getCategoria().getId_categoria() == (mar.getId_categoria())){
                    mar.getListaReparaciones().add(rep);
                }
            }
        }
        
        return listaCategorias;
    }

    public List<Categoria> listarCategoriasOrdenadasPorNombre() {
        List<Categoria> listaCategorias = categoriaDAO.obtenerCategoriasOrdenadasPorNombre();
        
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        for(Categoria mar : listaCategorias){
            for(Repuesto rep : listaRepuestosAuxiliar){
                if(rep.getCategoria().getId_categoria() == (mar.getId_categoria())){
                    mar.getListaRepuestos().add(rep);
                }
            }
        }
        
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Categoria mar : listaCategorias){
            for(Reparacion rep : listaReparacionesAuxiliar){
                if(rep.getCategoria().getId_categoria() == (mar.getId_categoria())){
                    mar.getListaReparaciones().add(rep);
                }
            }
        }
        
        return listaCategorias;
    }

    
    public Categoria obtenerCategoriaPorId(int id) {
        Categoria categoria = categoriaDAO.obtenerCategoria(id);
        
        List<Repuesto> listaRepuestosAuxiliar = repuestoDAO.obtenerRepuestos();
        for(Repuesto rep : listaRepuestosAuxiliar){
            if(rep.getCategoria().getId_categoria() == (categoria.getId_categoria())){
                categoria.getListaRepuestos().add(rep);
            }
        }
        
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Reparacion rep : listaReparacionesAuxiliar){
            if(rep.getCategoria().getId_categoria() == (categoria.getId_categoria())){
                categoria.getListaReparaciones().add(rep);
            }
        }
                
        return categoria;
    }
    
    public void editarCategoriaPorId(Categoria categoria){
        categoriaDAO.actualizarCategoria(categoria);
    }
    
    public void eliminarCategoriaPorId(int id){
        categoriaDAO.eliminarCategoria(id);
    }
    
    public boolean existeCategoria(String nombre) {   
        return categoriaDAO.existeCategoria(nombre);
    }
    
    public Categoria obtenerCategoriaPorNombre(String nombre){
        return categoriaDAO.obtenerCategoriaPorNombre(nombre);
    }

}


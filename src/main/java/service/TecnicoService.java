package service;

import dao.interfaces.TecnicoDAO;
import dao.interfaces.ReparacionDAO;
import dao.interfaces.VentaDAO;
import java.util.List;
import model.Tecnico;
import model.Reparacion;
import model.Venta;

public class TecnicoService {
    private final TecnicoDAO tecnicoDAO;
    private final VentaDAO ventaDAO;
    private final ReparacionDAO reparacionDAO;
    
    public TecnicoService(TecnicoDAO tecnicoDAO, VentaDAO ventaDAO, ReparacionDAO reparacionDAO){
        this.tecnicoDAO = tecnicoDAO;
        this.ventaDAO = ventaDAO;
        this.reparacionDAO = reparacionDAO;
    }
    
    public void agregarTecnico(Tecnico tecnico){
        tecnicoDAO.crearTecnico(tecnico);
    }
    
    public List<Tecnico> listarTecnicos() {
        List<Tecnico> listaTecnicos = tecnicoDAO.obtenerTecnicos();
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Tecnico cli : listaTecnicos){
            for(Reparacion rep : listaReparacionesAuxiliar){
                if(rep.getTecnico().getId_tecnico() == (cli.getId_tecnico())){
                    cli.getListaReparaciones().add(rep);
                }
            }
        }
        
        return listaTecnicos;
    }
    
    public Tecnico obtenerTecnicoPorId(int id) {
        Tecnico tecnico = tecnicoDAO.obtenerTecnico(id);
        List<Reparacion> listaReparacionesAuxiliar = reparacionDAO.obtenerReparaciones();
        for(Reparacion rep : listaReparacionesAuxiliar){
            if(rep.getTecnico().getId_tecnico() == (tecnico.getId_tecnico())){
                tecnico.getListaReparaciones().add(rep);
            }
        }
        
        return tecnico;
    }
    
    public List<Tecnico> busquedaDeTecnico(Tecnico tecnico){
        List<Tecnico> listaTecnico = tecnicoDAO.buscarTecnico(tecnico);
        return listaTecnico;
    }
    
    public void editarTecnicoPorId(Tecnico tecnico){
        tecnicoDAO.actualizarTecnico(tecnico);
    }
    
    public void eliminarTecnicoPorId(int id){
        tecnicoDAO.eliminarTecnico(id);
    }
    
    public Boolean existeTecnico(Tecnico tecnico){
        List<Tecnico> listaTecnicos = listarTecnicos();
        boolean existeTecnico = false;
        
        for(Tecnico cli : listaTecnicos){
            if(cli.getApellido_tecnico().equals(tecnico.getApellido_tecnico()) && (cli.getNombre_tecnico().equals(tecnico.getNombre_tecnico()))){
                existeTecnico = true;
                break;
            }
        }
        return existeTecnico;
    }
    
    public Boolean existeTelefonoTecnico(Tecnico tecnico){
        List<Tecnico> listaTecnicos = listarTecnicos();
        boolean existeTelefono = false;
        
        for(Tecnico cli : listaTecnicos){
            if(cli.getTelefono_tecnico().equals(tecnico.getTelefono_tecnico())){
                existeTelefono = true;
                break;
            }
        }
        return existeTelefono;
    }
    
    //Reportes Tecnicos
}

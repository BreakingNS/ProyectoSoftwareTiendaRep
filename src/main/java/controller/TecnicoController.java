package controller;

import java.util.ArrayList;
import java.util.List;
import model.Tecnico;
import service.TecnicoService;

public class TecnicoController {
    private final TecnicoService tecnicoService;

    public TecnicoController(TecnicoService tecnicoService) {
        this.tecnicoService = tecnicoService;
    }
    
    public void agregarTecnico(String nombre, String apellido, String telefono, String domicilio){
        Tecnico tecnico = new Tecnico(1, nombre, apellido, telefono, domicilio, new ArrayList<>());
        tecnicoService.agregarTecnico(tecnico);
    }
    
    public List<Tecnico> listarTecnicos(){
        List<Tecnico> listaTecnicos= tecnicoService.listarTecnicos();
        return listaTecnicos;
    }
    
    public Tecnico obtenerTecnicoPorId(int id){
        Tecnico tecnico = tecnicoService.obtenerTecnicoPorId(id);
        return tecnico;
    }
    
    public List<Tecnico> busquedaDeTecnico(String nombre, String apellido, String telefono, String domicilio){
        Tecnico tecnico = new Tecnico(0, nombre, apellido, telefono, domicilio, new ArrayList<>());
        List<Tecnico> listaTecnicos = tecnicoService.busquedaDeTecnico(tecnico);
        
        return listaTecnicos;
    }
    
    public void editarTecnico(int id, String nombre, String apellido, String telefono, String domicilio){
        Tecnico tecnico = new Tecnico(id, nombre, apellido, telefono, domicilio, new ArrayList<>());
        tecnicoService.editarTecnicoPorId(tecnico);
    }
    
    public void eliminarTecnico(int id){
        tecnicoService.eliminarTecnicoPorId(id);
    }
}

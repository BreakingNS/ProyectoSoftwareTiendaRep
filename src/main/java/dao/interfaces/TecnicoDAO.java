package dao.interfaces;

import java.util.List;
import model.Tecnico;

public interface TecnicoDAO {
    public void crearTecnico(Tecnico tecnico);
    public List<Tecnico> obtenerTecnicos();
    public Tecnico obtenerTecnico(int id);
    public List<Tecnico> buscarTecnico(Tecnico tecnico);
    public void actualizarTecnico(Tecnico tecnico);
    public void eliminarTecnico(int id);
}

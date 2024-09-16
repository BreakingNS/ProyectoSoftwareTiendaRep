package dao.interfaces;

import java.util.List;
import model.Repuesto;

public interface RepuestoDAO {
    public void crearRepuesto(Repuesto repuesto);
    public List<Repuesto> obtenerRepuestos();
    public Repuesto obtenerRepuesto(int id);
    public List<Repuesto> buscarRepuesto(Repuesto repuesto);
    public void actualizarRepuesto(Repuesto repuesto);
    public void eliminarRepuesto(int id);
    public int obtenerUltimoIdRepuesto();
}

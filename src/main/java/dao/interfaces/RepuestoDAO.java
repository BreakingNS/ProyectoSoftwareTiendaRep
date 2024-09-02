package dao.interfaces;

import java.util.List;
import model.Repuesto;

public interface RepuestoDAO {
    public void crearRepuesto(Repuesto repuesto);
    public List<Repuesto> obtenerRepuesto();
    public void actualizarRepuesto(Repuesto repuesto, int id);
    public void eliminarRepuesto(int id);
    public void toStringRepuesto();
}

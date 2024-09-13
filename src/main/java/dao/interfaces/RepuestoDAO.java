package dao.interfaces;

import java.util.List;
import model.Repuesto;

public interface RepuestoDAO {
    public void crearRepuesto(Repuesto repuesto);
    public List<Repuesto> obtenerRepuestos();
    public Repuesto obtenerRepuesto(int id);
    public List<Repuesto> buscarRepuesto(String nombreRepuesto, String marca, String categoria, String ubicacion, String stock, String precio);
    public void actualizarRepuesto(Repuesto repuesto);
    public void eliminarRepuesto(int id);
}

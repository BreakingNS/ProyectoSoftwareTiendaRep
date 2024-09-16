package dao.interfaces;

import java.util.List;
import model.NombreRepuesto;

public interface NombreRepuestoDAO {
    public void crearNombreRepuesto(NombreRepuesto nombreRepuesto);
    public List<NombreRepuesto> obtenerNombreRepuestos();
    public NombreRepuesto obtenerNombreRepuesto(int id);
    public void actualizarNombreRepuesto(NombreRepuesto nombreRepuesto);
    public void eliminarNombreRepuesto(int id);
    public boolean existeNombreRepuesto(String nombre);
    public NombreRepuesto obtenerNombreRepuestoPorNombre(String nombreRepuesto);
}

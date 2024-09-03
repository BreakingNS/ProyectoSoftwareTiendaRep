package dao.interfaces;

import java.util.List;
import model.NombreRepuesto;

public interface NombreRepuestoDAO {
    public void crearNombreRepuesto(NombreRepuesto nombreRepuesto);
    public List<NombreRepuesto> obtenerNombresRepuestos();
    public NombreRepuesto obtenerNombreRepuesto(int id);
    public void actualizarNombreRepuesto(NombreRepuesto nombreRepuesto);
    public void eliminarNombreRepuesto(int id);
    public void toStringNombreRepuestos();
}

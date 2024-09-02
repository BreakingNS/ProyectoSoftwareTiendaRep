package dao.interfaces;

import java.util.List;
import model.Marca;
import model.NombreRepuesto;

public interface NombreRepuestoDAO {
    public void crearNombreRepuesto(NombreRepuesto nombreRepuesto);
    public List<NombreRepuesto> obtenerNombresRepuestos();
    public void actualizarNombreRepuesto(NombreRepuesto nombreRepuesto, int id);
    public void eliminarNombreRepuesto(int id);
    public void toStringNombreRepuestos();
}

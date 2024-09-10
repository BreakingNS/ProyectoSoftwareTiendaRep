package dao.interfaces;

import java.util.List;
import model.Reparacion;
import model.ReparacionRepuesto;
import model.Repuesto;

public interface ReparacionRepuestoDAO {
    public void crearReparacionRepuesto(Reparacion reparacion, Repuesto repuesto);
    public List<ReparacionRepuesto> obtenerReparacionRepuestos();
    public List<ReparacionRepuesto> obtenerReparacionRepuestoPorReparacion(int id_reparacion);
    public List<ReparacionRepuesto> obtenerReparacionRepuestoPorRepuesto(int id_repuesto);
    public void actualizarReparacionRepuestoPorReparacion(int id_reparacion, int id_repuesto);
    public void actualizarReparacionRepuestoPorRepuesto(int id_reparacion, int id_repuesto);
    public void eliminarReparacionRepuesto(int id_reparacion, int id_repuesto);
}

package dao.interfaces;

import java.util.List;
import model.Repuesto;
import model.ReparacionRepuesto;

public interface ReparacionRepuestoDAO {
    public void crearReparacionRepuesto(int id_reparacion, int id_repuesto, int cantidad);
    //Correcto. Permite insertar múltiples repuestos asociados a una reparacion específica.
    public List<ReparacionRepuesto> obtenerReparacionRepuestos();
    public List<ReparacionRepuesto> obtenerReparacionRepuestoPorReparacion(int id_reparacion);
    public List<ReparacionRepuesto> obtenerReparacionRepuestoPorRepuesto(int id_repuesto);
    //Correcto. Estos métodos permiten obtener todas las asociaciones, por reparacion o por repuesto.
    public void actualizarAgregarReparacionRepuestoPorReparacion(int id_reparacion, List<Repuesto> listaRepuesto);
    //Permite agregar nuevos repuestos a una reparacion, lo cual es útil para actualizar la relación sin eliminar las existentes.
    public void actualizarEliminarReparacionRepuestoPorRepuesto(int id_reparacion, List<Repuesto> listaRepuesto);
    //Está destinado a eliminar relaciones específicas de repuestos asociados a una reparacion.
    public void eliminarReparacionRepuesto(int id_reparacion, int id_repuesto);
    //Correcto para eliminar una relación específica entre una reparacion y un repuesto.
    public void eliminarReparacionRepuestoPorReparacion(int id_reparacion);
    //Correcto para eliminar todas las relaciones de repuestos asociadas a una reparacion específica.
}
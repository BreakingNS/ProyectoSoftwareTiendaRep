package dao.interfaces;

import java.util.List;
import model.Repuesto;
import model.Venta;
import model.VentaRepuesto;

public interface VentaRepuestoDAO {
    public void crearVentaRepuesto(int id_venta, int id_repuesto, int cantidad);
    //Correcto. Permite insertar múltiples repuestos asociados a una venta específica.
    public List<VentaRepuesto> obtenerVentaRepuestos();
    public List<VentaRepuesto> obtenerVentaRepuestoPorVenta(int id_venta);
    public List<VentaRepuesto> obtenerVentaRepuestoPorRepuesto(int id_repuesto);
    //Correcto. Estos métodos permiten obtener todas las asociaciones, por venta o por repuesto.
    public void actualizarAgregarVentaRepuestoPorVenta(int id_venta, List<Repuesto> listaRepuesto);
    //Permite agregar nuevos repuestos a una venta, lo cual es útil para actualizar la relación sin eliminar las existentes.
    public void actualizarEliminarVentaRepuestoPorRepuesto(int id_venta, List<Repuesto> listaRepuesto);
    //Está destinado a eliminar relaciones específicas de repuestos asociados a una venta.
    public void eliminarVentaRepuesto(int id_venta, int id_repuesto);
    //Correcto para eliminar una relación específica entre una venta y un repuesto.
    public void eliminarVentaRepuestoPorVenta(int id_venta);
    //Correcto para eliminar todas las relaciones de repuestos asociadas a una venta específica.
}

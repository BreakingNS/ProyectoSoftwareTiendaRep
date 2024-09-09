package model;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReparacionTest {
    
    @Test
    public void pruebaCrearReparacion(){
        List<Reparacion> listaReparaciones = null;
        BigDecimal costo = new BigDecimal("17000");
        String detalles = "Viene roto de otro local";
        Date fecha_ingreso = new Date();
        Date fecha_devolucion = new Date(2024, 5, 8);
        System.out.println(fecha_devolucion);
        Categoria categoria = null;
        Cliente cliente = null;
        Estado estado = null;
        Reparacion rep = new Reparacion(10, costo, detalles, fecha_ingreso, fecha_devolucion, categoria, cliente, estado);
        assertEquals(10, rep.getId_reparacion());
        assertEquals(costo, rep.getCosto());
        assertEquals(detalles, rep.getDetalles());
        assertEquals(fecha_ingreso, rep.getFecha_ingreso());
        assertEquals(fecha_devolucion, rep.getFecha_devolucion());
        assertEquals(categoria, rep.getCategoria());
        assertEquals(null, rep.getCliente());
    }
    
}

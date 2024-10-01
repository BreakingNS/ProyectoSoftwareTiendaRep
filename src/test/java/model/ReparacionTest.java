package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class ReparacionTest {
    
    @Test
    public void pruebaCrearReparacion(){
        List<Reparacion> listaReparaciones = null;
        BigDecimal costo = new BigDecimal("17000");
        String detalles = "Viene roto de otro local";
        LocalDateTime fecha_ingreso = LocalDateTime.now();
        LocalDateTime fecha_devolucion = LocalDateTime.now();
        System.out.println(fecha_devolucion);
        Categoria categoria = null;
        Cliente cliente = null;
        Estado estado = null;
        Reparacion rep = new Reparacion(10, costo, detalles, fecha_ingreso, fecha_devolucion, null, categoria, cliente, estado, null);
        assertEquals(10, rep.getId_reparacion());
        assertEquals(costo, rep.getCosto());
        assertEquals(detalles, rep.getDetalles());
        assertEquals(fecha_ingreso, rep.getFecha_ingreso());
        assertEquals(fecha_devolucion, rep.getFecha_devolucion());
        assertEquals(null, rep.getFactura());
        assertEquals(categoria, rep.getCategoria());
        assertEquals(null, rep.getCliente());
        assertEquals(null, rep.getTecnico());
    }
    
}

package model;

import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class VentaTest {
    
    @Test
    public void pruebaCrearVenta(){
        Cliente cliente = null;
        Date ahora = new Date();
        BigDecimal valor = new BigDecimal("5774.25");
        Venta venta = new Venta(4, 17, ahora, cliente, valor);
        assertEquals(4, venta.getId_venta());
        assertEquals(17, venta.getCantidad());
        assertEquals(ahora, venta.getFecha_venta());
        assertEquals(cliente, venta.getCliente());
        assertEquals(valor, venta.getPrecioFinal());
    }
    
}

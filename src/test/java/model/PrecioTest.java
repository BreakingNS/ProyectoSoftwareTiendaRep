package model;

import java.math.BigDecimal;
import java.util.Date;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PrecioTest {
    
    @Test
    public void pruebaCrearPrecio(){
        Date ahora = new Date();
        BigDecimal valor = new BigDecimal("1999.99");
        Precio pre = new Precio(1, null, ahora, valor);
        assertEquals(1, pre.getId_precio());
        assertEquals(null, pre.getRepuesto());
        assertEquals(ahora, pre.getFechaPrecio());
        assertEquals(valor, pre.getValor());
    }
    
}

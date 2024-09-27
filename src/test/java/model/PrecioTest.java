package model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class PrecioTest {
    
    @Test
    public void pruebaCrearPrecio(){
        LocalDateTime ahora = LocalDateTime.now();
        BigDecimal valor = new BigDecimal("1999.99");
        Precio pre = new Precio(1, null, ahora, valor);
        assertEquals(1, pre.getId_precio());
        assertEquals(null, pre.getRepuesto());
        assertEquals(ahora, pre.getFechaPrecio());
        assertEquals(valor, pre.getValor());
    }
    
}
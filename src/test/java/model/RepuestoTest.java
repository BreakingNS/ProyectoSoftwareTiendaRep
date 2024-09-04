package model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class RepuestoTest {
    
    @Test
    public void pruebaCrearRepuesto(){
        List<Precio> listaPrecios = null;
        Repuesto rep = new Repuesto(6, 57, null, null, null, listaPrecios, null);
        assertEquals(6, rep.getId_repuesto());
        assertEquals(57, rep.getStock());
        assertEquals(null, rep.getNombreRepuesto());
        assertEquals(null, rep.getMarca());
        assertEquals(null, rep.getCategoria());
        assertEquals(null, rep.getListaPrecios());
        assertEquals(null, rep.getUbicacion());
    }
    
}

package model;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class UbicacionTest {
    
    @Test
    public void pruebaCrearUbicacion(){
        Ubicacion ubi = new Ubicacion(1, "Norte A", new ArrayList<>());
        assertEquals(1, ubi.getId_ubicacion());
        assertEquals("Norte A", ubi.getNombre_ubicacion());
    }

}

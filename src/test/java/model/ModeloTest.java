package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ModeloTest {
    
    @Test
    public void pruebaCrearModelo() {
        Modelo modelo = new Modelo(1, "Plus");

        assertEquals(1, modelo.getId_modelo());
        assertEquals("Plus", modelo.getNombre_modelo());
    }
}

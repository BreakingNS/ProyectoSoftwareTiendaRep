package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NombreRepuestoTest {

    @Test
    public void pruebaCrearNombreRepuesto(){
        NombreRepuesto nombreRepuesto = new NombreRepuesto(1, "Termostato");
        assertEquals(1, nombreRepuesto.getId_nombrerepuesto());
        assertEquals("Termostato", nombreRepuesto.getNombre_repuesto());
    }
}

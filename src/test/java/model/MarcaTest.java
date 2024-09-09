package model;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarcaTest {

    @Test
    public void pruebaCrearMarca() {
        Marca marca = new Marca(1, "Fiat", new ArrayList<>());

        assertEquals(1, marca.getId_marca());
        assertEquals("Fiat", marca.getNombre_marca());
        assertEquals(0, marca.getListaRepuestos().size());
    }
}

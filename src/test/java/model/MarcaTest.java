package model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MarcaTest {

    @Test
    public void pruebaCrearMarca() {
        // Crear una instancia de Marca
        Marca marca = new Marca(1, "Fiat");

        // Verificar que los valores son los esperados
        assertEquals(1, marca.getId_marca());
        assertEquals("Fiat", marca.getNombre_marca());
    }
}

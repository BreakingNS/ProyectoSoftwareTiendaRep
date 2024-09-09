package model;

import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CategoriaTest {
    
    @Test
    public void pruebaCrearCategoria(){
        Categoria cat = new Categoria(1, "Lavarropas", new ArrayList<>(), new ArrayList<>());
        assertEquals(1, cat.getId_categoria());
        assertEquals("Lavarropas", cat.getNombre_categoria());
    }
    
}

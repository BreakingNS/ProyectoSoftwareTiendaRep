package model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class CategoriaTest {
    
    @Test
    public void pruebaCrearCategoria(){
        List<Reparacion> listaReparaciones = null;
        Categoria cat = new Categoria(1, "Lavarropas", listaReparaciones);
        assertEquals(1, cat.getId_categoria());
        assertEquals("Lavarropas", cat.getNombre_categoria());
        assertEquals(null, listaReparaciones);
    }
    
}

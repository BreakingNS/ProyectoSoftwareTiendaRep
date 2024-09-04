package model;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EstadoTest {
    
    @Test
    public void pruebaCrearEstado(){
        List<Reparacion> listaRepuestos = null;
        Estado est = new Estado(1, "Entregado", listaRepuestos);
        assertEquals(1, est.getId_estado());
        assertEquals("Entregado", est.getNombre_estado());
        assertEquals(null, listaRepuestos);
    }
    
}

package model;

import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TecnicoTest {
    
    @Test
    public void pruebaCrearTecnico(){
        List<Reparacion> listaReparaciones = null;
        Tecnico tec = new Tecnico(1, "Nahuel", "Segura", "123456", "Achachay", listaReparaciones);

        assertEquals(1, tec.getId_tecnico());
        assertEquals("Nahuel", tec.getNombre_tecnico());
        assertEquals("Segura", tec.getApellido_tecnico());
        assertEquals("123456", tec.getTelefono_tecnico());
        assertEquals("Achachay", tec.getDomicilio_tecnico());
        assertEquals(null, tec.getListaReparaciones());
    }
    
}

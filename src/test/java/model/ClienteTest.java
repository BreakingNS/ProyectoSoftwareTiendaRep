package model;

import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


public class ClienteTest {
    
    @Test
    public void pruebaCrearCliente(){
        List<Reparacion> listaReparaciones = null;
        List<Venta> listaVentas = null;
        Cliente cli = new Cliente(1, "Nahuel", "Segura", "123456", listaVentas, listaReparaciones);

        assertEquals(1, cli.getId_cliente());
        assertEquals("Nahuel", cli.getNombre());
        assertEquals("Segura", cli.getApellido());
        assertEquals("123456", cli.getTelefono());
        assertEquals(null, cli.getListaReparaciones());
        assertEquals(null, cli.getListaVentas());
    }
}

package model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


public class PagadoTest {
    
    @Test
    public void pruebaCrearPagado(){
        Pagado pagado = new Pagado(1, "SI");
        assertEquals(1, pagado.getId_pagado());
        assertEquals("SI", pagado.getNombre_pago());
    }
    
}

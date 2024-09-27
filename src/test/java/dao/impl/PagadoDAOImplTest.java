package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.sql.Connection;
import java.util.List;
import model.Pagado;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PagadoDAOImplTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    
    private static PagadoDAOImpl pagadoDAO;

    public PagadoDAOImplTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
  
        pagadoDAO = new PagadoDAOImpl(connection);

    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        
        configuracion.crearTablaPagado();
    }
    
    @AfterEach
    public void tearDown() {
        configuracion.eliminarTablaPagado();
    }
    
    @Test
    public void eliminarTablas(){
        configuracion.eliminarTablaPagado();
    }
    
    @Test
    public void pruebaCrearPagado(){
        Pagado pagado = new Pagado(1, "Plus");
        Pagado pagado1 = new Pagado(2, "Smart");
        pagadoDAO.crearPagado(pagado);
        pagadoDAO.crearPagado(pagado1);
    }
    
    @Test
    public void pruebaObtenerPagados(){
        pruebaCrearPagado();
        List<Pagado> listaPagados = pagadoDAO.obtenerPagados();
        
        assertEquals(1, listaPagados.get(0).getId_pagado());
        assertEquals("Plus", listaPagados.get(0).getNombre_pago());
        assertEquals(2, listaPagados.get(1).getId_pagado());
        assertEquals("Smart", listaPagados.get(1).getNombre_pago());
    }
    
    @Test
    public void pruebaObtenerPagado(){
        pruebaCrearPagado();
        Pagado pagado = pagadoDAO.obtenerPagado(1);
        assertEquals(1, pagado.getId_pagado());
        assertEquals("Plus", pagado.getNombre_pago());
    }
    
    @Test
    public void pruebaModificarPagados(){
        pruebaCrearPagado();
        Pagado pagado1 = new Pagado(1, "Gama");
        Pagado pagado2 = new Pagado(2, "Plus Ultra");
        pagadoDAO.actualizarPagado(pagado1);
        pagadoDAO.actualizarPagado(pagado2);
        List<Pagado> listaPagados = pagadoDAO.obtenerPagados();
        assertEquals(1, listaPagados.get(0).getId_pagado());
        assertEquals("Gama", listaPagados.get(0).getNombre_pago());
        assertEquals(2, listaPagados.get(1).getId_pagado());
        assertEquals("Plus Ultra", listaPagados.get(1).getNombre_pago());
    }
    
    @Test
    public void pruebaEliminarPagados(){
        pruebaCrearPagado();
        pagadoDAO.eliminarPagado(1);
        List<Pagado> listaPagados = pagadoDAO.obtenerPagados();
        assertEquals(1, listaPagados.size());
        assertEquals(2, listaPagados.get(0).getId_pagado());
    }

}

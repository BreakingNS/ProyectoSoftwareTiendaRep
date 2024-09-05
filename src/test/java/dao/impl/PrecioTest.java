package dao.impl;

import config.ConexionDataBase;
import config.ConfiguracionDataBase;
import java.math.BigDecimal;
import java.sql.Connection;
import java.util.Date;
import java.util.List;
import model.Precio;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PrecioTest {
    
    private static ConexionDataBase conexionDataBase;
    private static ConfiguracionDataBase configuracion;
    private static Connection connection;
    private static PrecioDAOImpl precioDAO;
    
    public PrecioTest() {
    }
    
    @BeforeAll
    public static void setUpClass() throws ClassNotFoundException {
        conexionDataBase = new ConexionDataBase();
        connection = conexionDataBase.getConexionDBH2();
        precioDAO = new PrecioDAOImpl(connection);
    }
    
    @AfterAll
    public static void tearDownClass() {
        conexionDataBase.cerrarConexion(connection);
    }
    
    @BeforeEach
    public void setUp() {
        configuracion = new ConfiguracionDataBase(connection);
        //configuracion.crearTablaPrecio();
    }
    
    @AfterEach
    public void tearDown() {
        //configuracion.eliminarTablaPrecio();
    }

    @Test
    public void pruebaCrearPrecio(){
        Date ahora = new Date();
        System.out.println("Fecha a mostrar : " + ahora);
        BigDecimal valor1 = new BigDecimal("4000");
        BigDecimal valor2 = new BigDecimal("4000");
        
        Precio precio = new Precio();
        precio.setFechaPrecio(ahora);
        precio.setValor(valor1);
        precio.setRepuesto(null);
        Precio precio1 = new Precio();
        precio1.setFechaPrecio(ahora);
        precio1.setValor(valor1);
        precio1.setRepuesto(null);
        precioDAO.crearPrecio(precio);
        precioDAO.crearPrecio(precio1);
    }
    
    @Test
    public void pruebaObtenerPrecios(){
        pruebaCrearPrecio();
        List<Precio> listaPrecios = precioDAO.obtenerPrecios();
        System.out.println("fecha devuelta : " + listaPrecios.get(0).getFechaPrecio());
        System.out.println("fecha devuelta : " + listaPrecios.get(1).getFechaPrecio());
        /*
        assertEquals(1, listaPrecios.get(0).getId_precio());
        assertEquals(, listaPrecios.get(0).getFechaPrecio());
        assertEquals("Fiat", listaPrecios.get(0).getNombre_precio());
        assertEquals("Fiat", listaPrecios.get(0).getNombre_precio());
        
        
        assertEquals(2, listaPrecios.get(1).getId_precio());
        assertEquals("Renault", listaPrecios.get(1).getNombre_precio());
        */
    }
    
    @Test
    public void pruebaObtenerPrecio(){
        pruebaCrearPrecio();
        Precio precio = precioDAO.obtenerPrecio(1);
        assertEquals(1, precio.getId_precio());
        assertEquals("Fiat", precio.getNombre_precio());
    }
    
    @Test
    public void pruebaModificarPrecios(){
        pruebaCrearPrecio();
        Precio precio1 = new Precio(1, "Peugeot");
        Precio precio2 = new Precio(2, "Citroen");
        precioDAO.actualizarPrecio(precio1);
        precioDAO.actualizarPrecio(precio2);
        List<Precio> listaPrecios = precioDAO.obtenerPrecios();
        
        assertEquals(1, listaPrecios.get(0).getId_precio());
        assertEquals("Peugeot", listaPrecios.get(0).getNombre_precio());
        assertEquals(2, listaPrecios.get(1).getId_precio());
        assertEquals("Citroen", listaPrecios.get(1).getNombre_precio());
    }
    
    @Test
    public void pruebaEliminarPrecios(){
        pruebaCrearPrecio();
        precioDAO.eliminarPrecio(1);
        List<Precio> listaPrecios = precioDAO.obtenerPrecios();
        assertEquals(1, listaPrecios.size());
        assertEquals(2, listaPrecios.get(0).getId_precio());
    }
}

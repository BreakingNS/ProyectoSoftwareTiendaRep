package styles;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EstiloBoton {

    // Método para aplicar estilo a un botón ya existente
    
    public static void aplicarEstiloGris(JButton boton) {
        Color colorTexto = Color.BLACK;
        Color colorFondo = new Color(180, 180, 180); // Amarillo oscuro
        Border borde = BorderFactory.createLineBorder(new Color(120, 120, 120), 2); // Borde amarillo oscuro
        String fuente = "Arial";
        int tamanio = 18;
        aplicarEstiloGeneral(boton, colorTexto, colorFondo, borde, fuente, tamanio);
    }
    
    public static void aplicarEstiloAmarillo(JButton boton) {
        Color colorTexto = Color.BLACK;
        Color colorFondo = new Color(255, 204, 0); // Amarillo oscuro
        Border borde = BorderFactory.createLineBorder(new Color(153, 153, 0), 2); // Borde amarillo oscuro
        String fuente = "Arial";
        int tamanio = 18;
        aplicarEstiloGeneral(boton, colorTexto, colorFondo, borde, fuente, tamanio);
    }

    public static void aplicarEstiloVerde(JButton boton) {
        Color colorTexto = Color.WHITE;
        Color colorFondo = new Color(0, 153, 76); // Verde oscuro
        Border borde = BorderFactory.createLineBorder(new Color(0, 102, 51), 2); // Borde verde más oscuro
        String fuente = "Arial";
        int tamanio = 18;
        aplicarEstiloGeneral(boton, colorTexto, colorFondo, borde, fuente, tamanio);
    }

    public static void aplicarEstiloAzul(JButton boton) {
        Color colorTexto = Color.WHITE;
        Color colorFondo = new Color(0, 102, 204); // Azul medio
        Border borde = BorderFactory.createLineBorder(new Color(0, 76, 153), 2); // Borde azul oscuro
        String fuente = "Arial";
        int tamanio = 18;
        aplicarEstiloGeneral(boton, colorTexto, colorFondo, borde, fuente, tamanio);
    }

    public static void aplicarEstiloRojo(JButton boton) {
        Color colorTexto = Color.WHITE;
        Color colorFondo = new Color(204, 0, 0); // Rojo oscuro
        Border borde = BorderFactory.createLineBorder(new Color(153, 0, 0), 2); // Borde rojo más oscuro
        String fuente = "Arial";
        int tamanio = 18;
        aplicarEstiloGeneral(boton, colorTexto, colorFondo, borde, fuente, tamanio);
    }

    
    public static void aplicarEstiloGeneral(JButton boton, Color colorTexto, Color colorFondo, Border borde, String fuente, int tamanio) {
        // Establecer la fuente y el tamaño
        boton.setFont(new Font(fuente, Font.BOLD, tamanio));

        // Establecer color de texto y fondo
        boton.setForeground(colorTexto);
        boton.setBackground(colorFondo);

        // Establecer el borde
        boton.setBorder(borde);

        // Opción para eliminar los bordes del botón al hacer clic
        boton.setFocusPainted(false);
    }
}

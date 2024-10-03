package styles;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class EstiloBotonFallado {

    
    private static JButton setearBotonOscuro(JButton boton){
        String texto = "Botón Oscuro";
        String fuente = "Arial";                             
        int tamanio = 18;                                
        Color colorTexto = Color.WHITE;                      
        Color colorFondo = new Color(45, 45, 45);         
        Border borde = BorderFactory.createLineBorder(new Color(100, 100, 100), 2);
        
        return boton = crearBotonPersonalizado(texto, fuente, 0, Color.white, Color.orange, borde, boton);
    }
    
    // Método para personalizar un JButton
    private static JButton crearBotonPersonalizado(String texto, String fuente, int tamaño, Color colorTexto, Color colorFondo, Border borde, JButton boton) {
        
        // Establecer la fuente y el tamaño
        boton.setFont(new Font(fuente, Font.BOLD, tamaño));
        
        // Establecer color de texto y fondo
        boton.setForeground(colorTexto);
        boton.setBackground(colorFondo);
        
        // Establecer el borde
        boton.setBorder(borde);
        
        // Opción para eliminar los bordes del botón al hacer clic
        boton.setFocusPainted(false);
        
        return boton;
    }

}


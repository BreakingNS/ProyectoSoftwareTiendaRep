package app;

import app.SoftwareElectroClima;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLException;

public class TerminosYCondiciones {

    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";
    
    private static final String TERMINOS_FILE = "terminos.txt";

    public static void main(String[] args) {
        if (!terminosAceptados()) {
            mostrarTerminosYCondiciones();
        } else {
            // Iniciar la aplicación
            try {
                SoftwareElectroClima.iniciarAplicacion();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage());
            }
        }
    }

    private static boolean terminosAceptados() {
        boolean aceptados = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT terminosAceptados FROM Configuracion WHERE id = 1")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                aceptados = rs.getBoolean("terminosAceptados");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return aceptados;
    }

    private static void mostrarTerminosYCondiciones() {
        JTextArea textArea = new JTextArea();
        textArea.setText(cargarTerminos());
        textArea.setFont(new Font("Times New Roman", Font.PLAIN, 14)); // Configurar fuente
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setEditable(false); // No editable por el usuario

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setPreferredSize(new Dimension(500, 300)); // Ajusta el tamaño según sea necesario

        // Cambiar a showOptionDialog con opciones personalizadas
        int opcion = JOptionPane.showOptionDialog(null, scrollPane, "Términos y Condiciones",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, new Object[]{"Sí", "No"}, "Sí");

        if (opcion == 0) { // 0 corresponde a "Sí"
            // Guardar que los términos fueron aceptados
            guardarAceptacionTerminos();
            try {
                SoftwareElectroClima.iniciarAplicacion();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Error al iniciar la aplicación: " + e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "La aplicación se cerrará.");
            System.exit(0);
        }
    }


    private static String cargarTerminos() {
        StringBuilder contenido = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(Files.newInputStream(Paths.get(TERMINOS_FILE)), "UTF-8"))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                contenido.append(linea).append("\n");
            }
        } catch (IOException e) {
            return "No se pudieron cargar los términos y condiciones: " + e.getMessage();
        }
        return contenido.toString();
    }

    private static void guardarAceptacionTerminos() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "MERGE INTO Configuracion (id, terminosAceptados) VALUES (1, TRUE)")) {
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*

public class TerminosYCondiciones {

    private static final String DB_URL = "jdbc:h2:~/test";
    private static final String USER = "sa";
    private static final String PASSWORD = "";

    public static void main(String[] args) {
        if (!terminosAceptados()) {
            mostrarTerminosYCondiciones();
        } else {
            iniciarPrograma();
        }
    }

    private static boolean terminosAceptados() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT terminosAceptados FROM Configuracion WHERE id = 1")) {
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return rs.getBoolean("terminosAceptados");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    private static void mostrarTerminosYCondiciones() {
        JDialog dialogo = new JDialog();
        dialogo.setTitle("Términos y Condiciones");
        dialogo.setSize(600, 400);
        dialogo.setModal(true);
        dialogo.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JTextArea areaTexto = new JTextArea();
        areaTexto.setText(obtenerTerminos());
        areaTexto.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(areaTexto);

        JButton botonAceptar = new JButton("Aceptar");
        botonAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarTerminosAceptados();
                dialogo.dispose();
                iniciarPrograma();
            }
        });

        JButton botonRechazar = new JButton("Rechazar");
        botonRechazar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        JPanel panelBotones = new JPanel();
        panelBotones.add(botonAceptar);
        panelBotones.add(botonRechazar);

        dialogo.add(scrollPane, BorderLayout.CENTER);
        dialogo.add(panelBotones, BorderLayout.SOUTH);
        dialogo.setLocationRelativeTo(null);
        dialogo.setVisible(true);
    }

    private static String obtenerTerminos() {
        // Aquí puedes cargar los términos desde un archivo externo, por ejemplo, "terminos.txt"
        // O también podrías definirlos directamente en el código.
        // En este caso, los leeremos desde un archivo:

        try {
            return new String(java.nio.file.Files.readAllBytes(java.nio.file.Paths.get("terminos.txt")));
        } catch (Exception e) {
            e.printStackTrace();
            return "No se pudieron cargar los términos y condiciones.";
        }
    }

    private static void guardarTerminosAceptados() {
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement(
                     "MERGE INTO Configuracion (id, terminosAceptados) VALUES (1, TRUE)")) {
            stmt.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void iniciarPrograma() {
        // Aquí va el código para continuar con el programa principal
        JOptionPane.showMessageDialog(null, "Bienvenido al Software ElectroClima");
        
        
    }
}
*/


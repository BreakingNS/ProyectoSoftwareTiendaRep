package app;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EjemploContarElementos {
    public static void main(String[] args) {
        // Lista de elementos
        List<String> elementos = Arrays.asList("verde", "verde", "verde", "verde", "verde", 
                                               "verde", "verde", "verde", "verde", "verde",
                                               "rojo", "rojo", "rojo", "rojo", "rojo", "rojo", "rojo",
                                               "azul", "azul", "azul");

        // Mapa para contar las repeticiones
        Map<String, Integer> contador = new HashMap<>();
        
        // Llenar el mapa con las repeticiones
        for (String elemento : elementos) {
            contador.put(elemento, contador.getOrDefault(elemento, 0) + 1);
        }

        // Imprimir resultados con IDs de elemento y transacción
        int idElemento = 1;
        int idTransaccion = 1;
        for (Map.Entry<String, Integer> entry : contador.entrySet()) {
            System.out.println(entry.getValue() + " (elementos), " + idElemento + " (id elemento), " + idTransaccion + " (id transacción)");
            idElemento++;
        }
    }
}
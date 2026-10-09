package mx.unam.fi.die.poo.g7.practicas.practica4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Analiza la frecuencia de las palabras dentro de una oración.
 */
public class analizadorPalabras {
    private String oracion;
    private Map<String, Integer> frecuencias;

    /**
     * Inicializa el analizador con una oración mediante una cadena de tipo String.
     */
    public analizadorPalabras(String nuevaOracion) {
        this.oracion = nuevaOracion;
        this.frecuencias = new HashMap<>();
    }

    /**
     * Cuenta la frecuencia de cada palabra y devuelve un mapa de tipo Map con las frecuencias.
     */
    public Map<String, Integer> contarPalabras() {
        if (oracion == null) return frecuencias;

        String limpiar = oracion.toLowerCase();
        
        limpiar = limpiar.replaceAll("[^a-zaeioun0-9\\s]", "");

        String[] tokens = limpiar.split("\\s+");

        for (String palabra : tokens) {
            if (!palabra.isEmpty()) {
                if (frecuencias.containsKey(palabra)) {
                    int contador = frecuencias.get(palabra);
                    
                    frecuencias.put(palabra, contador + 1);
                } else {
                    frecuencias.put(palabra, 1);
                }
            }
        }
        return frecuencias;
    }

    /**
     * Obtiene la cantidad de palabras que aparecen más de una vez y devuelve un valor de tipo int.
     */
    public int obtenerNumerosDuplicados() {
        int duplicados = 0;

        for (String llave : frecuencias.keySet()) {
            if (frecuencias.get(llave) > 1) {
                duplicados++;
            }
        }

        return duplicados;
    }

    /**
     * Muestra las palabras duplicadas en consola mediante un valor de tipo boolean que indica el ordenamiento, y realiza la operación sin devolver un valor.
     */
    public void mostrarDuplicados(boolean ordenado) {
        if (ordenado) {
            TreeSet<String> clavesOrdenadas = new TreeSet<>();

            for (String palabra : frecuencias.keySet()) {
                if (frecuencias.get(palabra) > 1) {
                    clavesOrdenadas.add(palabra);
                }
            }

            if (clavesOrdenadas.isEmpty()) {
                System.out.println("No hay palabras duplicadas");
            } else {
                System.out.println("Palabras duplicadas:");
                for (String palabra : clavesOrdenadas) {
                    System.out.println(palabra + ": " + frecuencias.get(palabra));
                }
            }
        } else {
            boolean hayDuplicados = false;
            for (String palabra : frecuencias.keySet()) {
                if (frecuencias.get(palabra) > 1) {
                    if (!hayDuplicados) {
                        System.out.println("Palabras duplicadas:");
                        hayDuplicados = true;
                    }
                    System.out.println(palabra + ": " + frecuencias.get(palabra));
                }
            }
            if (!hayDuplicados) {
                System.out.println("No hay palabras duplicadas");
            }
        }
    }
}
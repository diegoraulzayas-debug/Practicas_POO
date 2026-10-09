package mx.unam.fi.die.poo.g7.practicas.practica4;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

/**
 * Clase encargada de analizar una oracion de texto, contando la frecuencia
 * de aparicion de cada palabra e identificando aquellas que se encuentran duplicadas.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class analizadorPalabras {
    private String oracion;
    private Map<String, Integer> frecuencias;

    /**
     * Construye un analizador de palabras con la oracion especificada.
     * Inicializa la estructura interna para almacenar las frecuencias.
     *
     * @param nuevaOracion Texto que sera analizado.
     */
    public analizadorPalabras(String nuevaOracion) {
        this.oracion = nuevaOracion;
        this.frecuencias = new HashMap<>();
    }

    /**
     * Cuenta la frecuencia de aparicion de cada palabra en la oracion.
     * Limpia la oracion conservando caracteres alfanumericos y espacios,
     * la divide en palabras y contabiliza las repeticiones.
     *
     * @return Mapa que relaciona cada palabra con su frecuencia de aparicion.
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
     * Calcula la cantidad total de palabras distintas que aparecen mas de una vez.
     *
     * @return El numero de palabras duplicadas encontradas en la oracion.
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
     * Muestra en consola las palabras duplicadas junto con su frecuencia de aparicion.
     *
     * @param ordenado {@code true} para mostrar las palabras en orden alfabetico;
     *                 {@code false} para mostrarlas segun el orden del mapa.
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
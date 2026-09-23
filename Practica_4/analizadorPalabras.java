import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class analizadorPalabras {
    private String oracion;
    private Map<String, Integer> frecuencias;

    public analizadorPalabras(String nuevaOracion) {
        this.oracion = nuevaOracion;
        this.frecuencias = new HashMap<>();
    }

    public Map<String, Integer> contarPalabras() {
        if (oracion == null) return frecuencias;

        String limpiar = oracion.toLowerCase();
        
        limpiar = limpiar.replaceAll("[^a-záéíóúñ0-9\\s]", "");

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

    public int obtenerNumerosDuplicados() {
        int duplicados = 0;

        for (String llave : frecuencias.keySet()) {
            if (frecuencias.get(llave) > 1) {
                duplicados++;
            }
        }

        return duplicados;
    }

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
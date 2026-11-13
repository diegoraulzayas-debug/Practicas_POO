package mx.unam.fi.die.poo.g7.practicas.practica11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Clase encargada de gestionar la apertura, lectura y analisis de un archivo de
 * texto,
 * contabilizando el total de palabras contenidas y almacenando su texto integro
 * mediante el manejo de excepciones de entrada/salida ({@link IOException}).
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel
 *         Sulvaran
 * @version 1.0
 */
public class AnalizadorDeArchivo {

    // Atributos encapsulados
    /** Referencia al archivo fisico que sera analizado. */
    private File archivo;

    /** Cadena que almacena el contenido completo leido del archivo de texto. */
    private String contenidoDelTexto;

    /** Contador del numero total de palabras encontradas en el archivo. */
    private int totalPalabras;

    /**
     * Bandera que indica si el archivo existe y fue asociado correctamente en el
     * constructor.
     */
    private boolean archivoListo; // Nos avisa si el constructor funcionó bien

    /**
     * Construye un nuevo objeto {@code AnalizadorDeArchivo} verificando la
     * existencia
     * fisica del archivo en la ruta especificada dentro de un bloque
     * {@code try-catch}.
     *
     * @param rutaAbsoluta Ruta o nombre del archivo de texto que se desea analizar.
     */
    // CONSTRUCTOR CON TRY-CATCH
    public AnalizadorDeArchivo(String rutaAbsoluta) {
        this.contenidoDelTexto = "";
        this.totalPalabras = 0;

        try {
            // Intentamos asociar el archivo
            this.archivo = new File(rutaAbsoluta);

            // Si se ejecuta desde otra carpeta (ej. raiz del proyecto o carpeta test),
            // buscamos el archivo dentro del paquete junto a las clases compiladas
            if (!this.archivo.exists() && AnalizadorDeArchivo.class.getResource(rutaAbsoluta) != null) {
                try {
                    this.archivo = new File(AnalizadorDeArchivo.class.getResource(rutaAbsoluta).toURI());
                } catch (Exception e) {
                    // Se conserva la ruta original si no se puede resolver por URI
                }
            }

            // Verificamos físicamente si el archivo existe
            if (this.archivo.exists()) {
                this.archivoListo = true; // Todo en orden
            } else {
                // Si no existe, provocamos un error intencional para caer en el catch
                throw new IOException("El archivo no existe en la ruta: " + rutaAbsoluta);
            }

        } catch (IOException error) {
            this.archivoListo = false; // Marcamos que el objeto no está listo
            System.out.println("Error al crear el objeto: " + error.getMessage());
        }
    }

    /**
     * Lee el contenido del archivo linea por linea utilizando un
     * {@link BufferedReader},
     * acumula el texto leido y contabiliza las palabras separadas por espacios.
     * Si el archivo no fue cargado correctamente en el constructor, aborta la
     * lectura.
     */
    // Método para leer y contar
    public void procesarArchivo() {
        // Si el constructor falló (el archivo no existía), detenemos el proceso aquí
        // mismo
        if (this.archivoListo == false) {
            System.out.println("No se puede leer porque el archivo no se cargó correctamente.");
            return; // Termina la ejecución del método
        }

        // TRY-CATCH para la lectura del archivo
        try {
            FileReader lectorBase = new FileReader(this.archivo);
            BufferedReader lector = new BufferedReader(lectorBase);

            String linea;

            while ((linea = lector.readLine()) != null) {
                // Construimos el texto concatenando
                this.contenidoDelTexto = this.contenidoDelTexto + linea + "\n";

                // Contamos las palabras separando por espacios
                String[] partes = linea.split(" ");
                for (int i = 0; i < partes.length; i++) {
                    if (partes[i].length() > 0) {
                        this.totalPalabras = this.totalPalabras + 1;
                    }
                }
            }

            lector.close();

        } catch (IOException errorLectura) {
            System.out.println("Error mientras se leía el contenido: " + errorLectura.getMessage());
        }
    }

    // Getters
    /**
     * Obtiene el contenido completo del archivo de texto procesado.
     *
     * @return Cadena con el texto integro del archivo.
     */
    public String getContenidoDelTexto() {
        return this.contenidoDelTexto;
    }

    /**
     * Obtiene la cantidad total de palabras contabilizadas en el archivo.
     *
     * @return Numero total de palabras encontradas.
     */
    public int getTotalPalabras() {
        return this.totalPalabras;
    }
}

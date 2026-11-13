package mx.unam.fi.die.poo.g7.practicas.practica11;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Clase principal de ejecucion que construye una interfaz grafica con Swing
 * para leer el archivo {@code prueba.txt}, mostrar su contenido en pantalla
 * y visualizar el conteo total de palabras empleando
 * {@link AnalizadorDeArchivo}.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel
 *         Sulvaran
 * @version 1.0
 */
public class Main {

    /**
     * Constructor por defecto de la clase Main.
     */
    public Main() {
    }

    /**
     * Metodo principal que inicializa la ventana grafica, configura los componentes
     * visuales y asocia el evento del boton para procesar el archivo de texto.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {

        // 1. Crear la ventana principal
        JFrame ventana = new JFrame("Contador de Palabras");
        ventana.setSize(500, 400);
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setLayout(new BorderLayout());

        // 2. Crear panel superior con el botón y el contador
        JPanel panelSuperior = new JPanel();

        // Cambiamos el texto del botón para que sea más claro
        JButton botonCargar = new JButton("Leer prueba.txt");
        JLabel etiquetaPalabras = new JLabel("Total de palabras: 0");

        panelSuperior.add(botonCargar);
        panelSuperior.add(etiquetaPalabras);

        // 3. Crear el cuadro de texto
        JTextArea cuadroTexto = new JTextArea();
        cuadroTexto.setEditable(false);
        JScrollPane scrollPanel = new JScrollPane(cuadroTexto);

        // 4. Armar la ventana
        ventana.add(panelSuperior, BorderLayout.NORTH);
        ventana.add(scrollPanel, BorderLayout.CENTER);

        // 5. Acción del botón (Mucho más simple ahora)
        botonCargar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Usamos directamente el nombre de tu archivo
                String rutaFija = "prueba.txt";

                // Conectamos con tu clase de POO
                AnalizadorDeArchivo miAnalizador = new AnalizadorDeArchivo(rutaFija);
                miAnalizador.procesarArchivo();

                // Actualizamos la interfaz gráfica con los resultados
                etiquetaPalabras.setText("Total de palabras: " + miAnalizador.getTotalPalabras());
                cuadroTexto.setText(miAnalizador.getContenidoDelTexto());
            }
        });

        // 6. Mostrar la ventana
        ventana.setVisible(true);
    }
}

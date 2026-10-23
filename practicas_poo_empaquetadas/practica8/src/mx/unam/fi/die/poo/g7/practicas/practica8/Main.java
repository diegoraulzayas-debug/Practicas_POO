package mx.unam.fi.die.poo.g7.practicas.practica8;

import java.util.ArrayList;

/**
 * Clase principal de ejecucion para la demostracion de polimorfismo con interfaces.
 * Crea instancias de {@link Edificio}, {@link Auto} y {@link Bicicleta},
 * las almacena en una coleccion polimorfica de tipo {@link HuellaCarbono}
 * e invoca dinamicamente el metodo {@link HuellaCarbono#getHuellaCarbono()}.
 *
 * @author Julius Carlos, Diego Zayas, Emanuel Porto, Yahir Romero, Axel Sulvaran
 * @version 1.0
 */
public class Main {

    /**
     * Constructor por defecto de la clase Main.
     */
    public Main() {
    }

    /**
     * Metodo principal que ejecuta la creacion de los objetos, su almacenamiento
     * en un ArrayList polimorfico y la iteracion para mostrar el calculo de emisiones.
     *
     * @param args Argumentos de la linea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        // Creación directa de objetos con los atributos indispensables solicitados
        Edificio corporativo = new Edificio(2500.0, 5, 110.0);
        Auto vehiculoUrbano = new Auto(12000.0, 14.5);
        Bicicleta biciRuta = new Bicicleta(3200.0, "Aluminio");

        // Almacenamiento polimórfico en el ArrayList
        ArrayList<HuellaCarbono> listaHuellaCarbono = new ArrayList<>();
        listaHuellaCarbono.add(corporativo);
        listaHuellaCarbono.add(vehiculoUrbano);
        listaHuellaCarbono.add(biciRuta);

        System.out.println("--- CÁLCULO POLIMÓRFICO DE HUELLA DE CARBONO ---\n");

        // Recorrido del ArrayList ejecutando el método getHuellaCarbono()
        // polimórficamente
        for (HuellaCarbono elemento : listaHuellaCarbono) {
            // Se identifica el objeto por medio de su método toString()
            System.out.println(elemento);

            // Invocación polimórfica en tiempo de ejecución
            System.out.printf("Huella de carbono calculada: %,.2f kg CO2e%n", elemento.getHuellaCarbono());
            System.out.println("\n");
        }
    }
}

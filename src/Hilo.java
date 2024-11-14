import java.util.Random;

/**
 * Clase hilo que implementa la interfaz Runnable
 * @author cristian
 * @version 1.0
 */
public class Hilo implements Runnable {
    //variables finales de clase
    private final Parking parking;
    private final int idCoche;

    /**
     * Constructor de la clase
     * @param parking el parking de coches
     * @param idCoche el id del coche
     */
    public Hilo(Parking parking, int idCoche) {
        this.parking = parking;
        this.idCoche = idCoche;
    }

    /**
     * metodo para iniciar el hilo
     */
    @Override
    public void run() {
        //bucle infinito
        while (true) {
            try {
                //llamamos a los metodos y dormimos el hilo
                parking.logicaAparcar(idCoche);
                Thread.sleep(new Random().nextInt(1000) + 3000);
                parking.logicaSalir(idCoche);
                Thread.sleep(new Random().nextInt(1000) + 3000);
            } catch (InterruptedException e) {
                System.out.println("Coche " + idCoche + " ha sido interrumpido.");
            }
        }
    }
}

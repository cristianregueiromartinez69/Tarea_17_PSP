import java.util.Random;

public class Hilo implements Runnable {
    private final Parking parking;
    private final int idCoche;

    public Hilo(Parking parking, int idCoche) {
        this.parking = parking;
        this.idCoche = idCoche;
    }

    @Override
    public void run() {
        while (true) {
            try {
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

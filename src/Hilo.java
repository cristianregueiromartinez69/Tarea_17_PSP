public class Hilo implements Runnable {

    private Parking parking;


    public Hilo(Parking parking) {
        this.parking = parking;
    }

    @Override
    public void run() {
        try{
            while(true){
                parking.logicaAparcar();
                parking.logicaSalir();
            }

        } catch (InterruptedException e) {
            System.out.println("Ups, ha habido un error a la hora de ejecucion de hilos");
        }

    }
}

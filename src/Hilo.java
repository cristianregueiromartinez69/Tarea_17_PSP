public class Hilo implements Runnable {

    private Parking parking;
    private int numHilos;
    private int maxHilos;



    public Hilo(Parking parking, int numHilos, int maxHilos) {
        this.parking = parking;
        this.numHilos = numHilos;
        this.maxHilos = maxHilos;
    }

    @Override
    public void run() {

        if(numHilos < maxHilos) {
            Thread hiloHijo = new Thread(new Hilo(parking,numHilos + 1, maxHilos));
            hiloHijo.start();
        }

        try{
            for(int i = 0; i < 20; i++){
                parking.logicaAparcar();
                parking.logicaSalir();
            }

        } catch (InterruptedException e) {
            System.out.println("Ups, ha habido un error a la hora de ejecucion de hilos");
        }

    }
}

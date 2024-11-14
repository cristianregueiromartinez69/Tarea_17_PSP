public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking();
        Thread hilos = new Thread(new Hilo(parking));

        hilos.start();



    }
}
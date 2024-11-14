public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking();
        Coches coches = new Coches();
        Thread hilos = new Thread(new Hilo(parking));


    }
}
public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking();
        Coches coches = new Coches();
        Thread hilo = new Thread(new Hilo(parking, 0, coches.getCochesExistentes()));

        hilo.start();


    }


}
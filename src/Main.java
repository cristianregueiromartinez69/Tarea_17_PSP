public class Main {
    public static void main(String[] args) {

        Parking parking = new Parking();
        Thread hilo = new Thread(new Hilo(parking));

        hilo.start();


    }


}
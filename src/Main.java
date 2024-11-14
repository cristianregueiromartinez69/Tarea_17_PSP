/**
 * clase main donde ejecutamos el programa
 * @author cristian
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        //objeto tipo coches
        Coches coches = new Coches();
        //objeto de tipo parking con las plazas
        Parking parking = new Parking(20);
        //bucle para iniciar los hilos
        for (int i = 1; i <= coches.getNumCoches(); i++) {
            new Thread(new Hilo(parking, i)).start();
        }
    }
}

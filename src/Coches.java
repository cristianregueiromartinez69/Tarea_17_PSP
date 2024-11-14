public class Coches {

    private int numCoches = 10;

    public synchronized int getNumCoches() {
        return numCoches;
    }
}

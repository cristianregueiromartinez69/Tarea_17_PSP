public class Plazas {

    private int numPlazasOcupadas = 0;
    private int minPlazas  = 0;
    private int maxPlazas = 20;

    public synchronized void aumentarPlazas() {
        numPlazasOcupadas++;
    }

    public synchronized void disminuirNumPlazas() {
        numPlazasOcupadas--;
    }

    public synchronized int getNumPlazasOcupadas() {
        return numPlazasOcupadas;
    }
    public synchronized int getMinPlazas() {
        return minPlazas;
    }
    public synchronized int getMaxPlazas() {
        return maxPlazas;
    }

    public synchronized int getCalculoPlazasLibres() {
        return maxPlazas - numPlazasOcupadas;
    }


}

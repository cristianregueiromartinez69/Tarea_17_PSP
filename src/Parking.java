import java.util.ArrayList;
import java.util.List;

public class Parking {

    private Plazas plazas;
    private int numeroCoches = 10;
    private int plazasDisponibles;




    public Parking(Plazas plazas) {
        this.plazas = plazas;
    }

    public Parking() {

    }

    public synchronized void logicaAparcar() throws InterruptedException {
        if(plazasDisponibles == plazas.getMaxPlazas()){
            wait();
        }
        else{
            plazasDisponibles++;
            System.out.println("Entrada: ");
        }
    }


}

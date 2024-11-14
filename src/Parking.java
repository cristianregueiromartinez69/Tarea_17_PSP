import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Parking {

    Plazas plazas = new Plazas();
    private int numeroCoche = 0;

    private Random random = new Random();





    public Parking(Plazas plazas) {
        this.plazas = plazas;
    }

    public Parking() {

    }

    public synchronized void logicaAparcar() throws InterruptedException {
        if(plazas.getNumPlazasOcupadas() == plazas.getMaxPlazas()){
            wait();
        }
        else{
            plazas.aumentarPlazas();
            numeroCoche++;
            System.out.println("Entrada: " + "Coche " + numeroCoche + " aparca en " + " plaza numero: " + plazas.getNumPlazasOcupadas());
            System.out.println("Plazas libres: " + plazas.getCalculoPlazasLibres());
            System.out.println("Parking: " + plazas.getNumPlazasOcupadas() + "/" + plazas.getMaxPlazas());
            Thread.sleep(random.nextInt(1000)+3000);
        }
        notifyAll();
    }


    public synchronized void logicaSalir() throws InterruptedException {
        if(plazas.getNumPlazasOcupadas() == 0){
            wait();
        }
        else{
            plazas.disminuirNumPlazas();
            numeroCoche--;
            System.out.println("Salida: " + "Coche " + numeroCoche + " sale de " + " plaza numero: " + plazas.getNumPlazasOcupadas());
            System.out.println("Plazas libres: " + plazas.getCalculoPlazasLibres());
            System.out.println("Parking: " + plazas.getNumPlazasOcupadas() + "/" + plazas.getMaxPlazas());
            Thread.sleep(random.nextInt(1000)+3000);
        }
        notifyAll();
    }







}

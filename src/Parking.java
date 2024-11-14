import java.util.ArrayList;
import java.util.List;

/**
 * Clase parking para la logica del aparcamiento
 * @author cristian
 * @version 1.0
 */
public class Parking {
    //variables de clase
    private final int maxPlazas;
    private final List<Integer> plazas;

    /**
     * Constructor de la clase
     * @param maxPlazas el maximo de plazas
     */
    public Parking(int maxPlazas) {
        this.maxPlazas = maxPlazas;
        this.plazas = new ArrayList<>();
    }

    /**
     * metodo para la logica de aparcar el coche
     * @param idCoche el id del coche
     * @throws InterruptedException lanzamos una excepcion
     */
    public synchronized void logicaAparcar(int idCoche) throws InterruptedException {
        /*
          Explicacion:
          1. mientras el tamaño de la lista sea mayor o igual que el maximo de plazas, espera
          2. añadimos un coche a la plaza, imprimimos el resultado
          3. notificamos
         */
        while (plazas.size() >= maxPlazas) {
            wait();
        }
        plazas.add(idCoche);
        System.out.println("ENTRADA: Coche " + idCoche + " aparca.");
        System.out.println("Plazas libres: " + (maxPlazas - plazas.size()));
        System.out.println(getInformationPlazas(plazas));
        notifyAll();
    }

    /**
     * metodo para manejar la logica de salir del aparcamiento
     * @param idCoche el id del coche
     * @throws InterruptedException lanzamos la excepcion
     */
    public synchronized void logicaSalir(int idCoche) throws InterruptedException {
        /*
          Explicacion:
          1. mientras la plaza no contenga el id del coche, esperamos
          2. si no es así, borramos el coche de la lista
          3. imprimimos y notificamos
         */
        while (!plazas.contains(idCoche)) {
            wait();
        }
        plazas.remove(Integer.valueOf(idCoche));
        System.out.println("SALIDA: Coche " + idCoche + " sale.");
        System.out.println("Plazas libres: " + (maxPlazas - plazas.size()));
        System.out.println(getInformationPlazas(plazas));
        notifyAll();
    }

    public String getInformationPlazas(List<Integer> numPlazas){
        return "Parking: " + numPlazas.size() + "/20";
    }


}

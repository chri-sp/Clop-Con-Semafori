


import java.util.logging.Level;
import java.util.logging.Logger;

public class ThVisualizza extends Thread {

    
    private cDatiCondivisi ptrDati;
    private Semaforo sinc1;
    private Semaforo sinc2;
    
    public ThVisualizza(cDatiCondivisi ptrDati, Semaforo sinc1, Semaforo sinc2) {
        this.ptrDati = ptrDati;
        this.sinc1 = sinc1;
        this.sinc2 = sinc2;
    }
    
    public void run() {

        while (true) {
            sinc1.Wait();           
            
            if (Thread.currentThread().isInterrupted()) {
                break;
            }
            ptrDati.visualizzaCavalli();
            
            sinc2.Signal();
        }
    }
}

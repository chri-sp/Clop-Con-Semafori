

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Clop {

    public static void main(String[] args) {

        try {
            cDatiCondivisi dati = new cDatiCondivisi();
            Semaforo sinc1 = new Semaforo(1);
            Semaforo sinc2 = new Semaforo(0);

            ThCorsa Clop1 = new ThCorsa(1, dati, sinc1, sinc2);
            ThCorsa Clop2 = new ThCorsa(2, dati, sinc1, sinc2);
            ThCorsa Clop3 = new ThCorsa(3, dati, sinc1, sinc2);
            ThCorsa Clop4 = new ThCorsa(4, dati, sinc1, sinc2);
            ThCorsa Clop5 = new ThCorsa(5, dati, sinc1, sinc2);
            ThVisualizza tv = new ThVisualizza(dati, sinc1, sinc2);

            tv.start();
            Clop1.start();
            Clop2.start();
            Clop3.start();
            Clop4.start();
            Clop5.start();

            dati.waitFinito();
            Clop1.interrupt();
            Clop2.interrupt();
            Clop3.interrupt();
            Clop4.interrupt();
            Clop5.interrupt();
            
   
            dati.waitSem1();
            dati.waitSem2();
            dati.waitSem3();
            dati.waitSem4();
            dati.waitSem5();
            
            if (ThVisualizza.currentThread().isAlive()) {
                sinc1.Signal();
                tv.interrupt();
            }
            
            System.out.println("Ha vinto il cavallo numero "+dati.getVincitore());

        } catch (InterruptedException ex) {
            Logger.getLogger(Clop.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}

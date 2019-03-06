

import java.util.logging.Level;
import java.util.logging.Logger;

public class ThCorsa extends Thread {

    private int nThread;
    private cDatiCondivisi ptrDati;
    private Semaforo sinc1;
    private Semaforo sinc2;

    public ThCorsa(int nT, cDatiCondivisi dati, Semaforo sinc1, Semaforo sinc2) {
        this.nThread = nT;
        this.ptrDati = dati;
        this.sinc1 = sinc1;
        this.sinc2 = sinc2;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 50; i++) {

                sinc2.Wait();
                switch (this.nThread) {
                    case 1:
                        ptrDati.setnClop1(i);
                        break;

                    case 2:
                        ptrDati.setnClop2(i);
                        break;

                    case 3:
                        ptrDati.setnClop3(i);
                        break;

                    case 4:
                        ptrDati.setnClop4(i);
                        break;

                    case 5:
                        ptrDati.setnClop5(i);
                        break;
                }
                sinc1.Signal();

                if (Thread.currentThread().isInterrupted()) {
                    break;
                }

                Thread.sleep((int) (Math.random() * 10));

            }
            if (!Thread.currentThread().isInterrupted()) {
                ptrDati.signalFinito();
                ptrDati.setVincitore(nThread);
            }

        } catch (InterruptedException ex) {

        }

        switch (this.nThread) {
            case 1:
                ptrDati.signalSem1();
                break;

            case 2:
                ptrDati.signalSem2();
                break;

            case 3:
                ptrDati.signalSem3();
                break;

            case 4:
                ptrDati.signalSem4();
                break;

            case 5:
                ptrDati.signalSem5();
                break;
        }

    }

}

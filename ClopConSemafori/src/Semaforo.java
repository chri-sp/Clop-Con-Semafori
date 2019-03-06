



public class Semaforo {

    int valore;

    public Semaforo(int initial) {
        valore = initial;
    }

    synchronized public void Wait() {
        while (valore == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valore--;
    }

    synchronized public void Signal() {
        valore++;
        notify();
    }

    synchronized public void P() {
        while (valore == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
        valore--;
    }

    synchronized public void V() {
        valore++;
        notify();
    }
}

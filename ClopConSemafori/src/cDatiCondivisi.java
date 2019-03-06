


import java.util.concurrent.Semaphore;


public class cDatiCondivisi {

    
    private int nClop1;
    private int nClop2;
    private int nClop3;
    private int nClop4;
    private int nClop5;
    
    private Semaphore finito;
    private int vincitore;

    private Semaphore sem1;
    private Semaphore sem2;
    private Semaphore sem3;
    private Semaphore sem4;    
    private Semaphore sem5;   
    
    public cDatiCondivisi() {
        this.nClop1 = 0;
        this.nClop2 = 0;
        this.nClop3 = 0;
        this.nClop4 = 0;
        this.nClop5 = 0;
        sem1 = new Semaphore(0);
        sem2 = new Semaphore(0);
        sem3 = new Semaphore(0);
        sem4 = new Semaphore(0);
        sem5 = new Semaphore(0);
        
        finito = new Semaphore(0);
        vincitore=0;
    }    
    
    public synchronized void visualizzaCavalli() {
            System.out.println("Numero passi:");            
            System.out.println("Clop1:" + getnClop1());
            System.out.println("Clop2:" + getnClop2());
            System.out.println("Clop3:" + getnClop3());
            System.out.println("Clop4:" + getnClop4());
            System.out.println("Clop5:" + getnClop5());    
    }
    
    public int getVincitore(){
        return this.vincitore;
    }
    public void setVincitore(int s){
        vincitore = s;
    }
    
    public void waitFinito() throws InterruptedException {
        finito.acquire();
    }
    public void signalFinito() {
        finito.release();
    }
    public void waitSem1() throws InterruptedException {
        sem1.acquire();
    }
    public void signalSem1() {
        sem1.release();
    }
    public void waitSem2() throws InterruptedException {
        sem2.acquire();
    }
    public void signalSem2() {
        sem2.release();
    }
    public void waitSem3() throws InterruptedException {
        sem3.acquire();
    }
    public void signalSem3() {
        sem3.release();
    }
    public void waitSem4() throws InterruptedException {
        sem4.acquire();
    }
    public void signalSem4() {
        sem4.release();
    }
    public void waitSem5() throws InterruptedException {
        sem5.acquire();
    }
    public void signalSem5() {
        sem5.release();
    }
    
    public synchronized int getnClop1() {
        return nClop1;
    }
    
    public synchronized int getnClop2() {
        return nClop2;
    }
    
    public synchronized int getnClop3() {
        return nClop3;
    }
    
    public synchronized int getnClop4() {
        return nClop4;
    }
    
    public synchronized int getnClop5() {
        return nClop5;
    }
    
    public synchronized void setnClop1(int nClop1) {
        this.nClop1 = nClop1;
    }
    
    public synchronized void setnClop2(int nClop2) {
        this.nClop2 = nClop2;
    }
    
    public synchronized void setnClop3(int nClop3) {
        this.nClop3 = nClop3;
    }
    
    public synchronized void setnClop4(int nClop4) {
        this.nClop4 = nClop4;
    }
    
    public synchronized void setnClop5(int nClop5) {
        this.nClop5 = nClop5;
    }

}

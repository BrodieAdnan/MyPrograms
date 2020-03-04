package incrementatorethread;

public class Buffer {
    private int numero;
    Buffer(){
        numero=0;
    }
    synchronized void incrementa() throws InterruptedException{
        numero++;
        notifyAll();
    }
    void incrementazione(){
        numero++;
    }
    int getNumero(){
        return numero;
    }
}

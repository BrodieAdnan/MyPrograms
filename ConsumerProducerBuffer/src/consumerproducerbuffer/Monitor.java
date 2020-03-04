package consumerproducerbuffer;

public class Monitor {
    int pos;
    int lung;
    private int[] buffer; //NOT CIRCOLAR BUFFER.

    public Monitor() {
        lung=1001; //VARIABLE TO CHANGE.
        pos=0; //indica la posizione corrente nel buffer.
        buffer=new int[lung];
    }

    synchronized void set(int numero) throws InterruptedException {
        while(pos==lung){
            wait(); //aspetta fino a quando il buffer è pieno.
        }
        buffer[pos]=numero; //assegnazione nel buffer e incremento la posizione corrente.
        pos++;
        notifyAll(); //avvisa tutti i thread in attesa che il buffer è accessibile e non vuoto.
    }
    
    //prova
    void setNotSynchronized(int numero) { //non gestisce la sincronizzazione tra i thread.
        buffer[pos++]=numero;
    }

    synchronized int get() throws InterruptedException {
        while(pos==0){
            wait(); //aspetta fino a quando il buffer è vuoto.
        }
        notifyAll(); //avvisa tutti i thread in attesa che il buffer è accessibile e non pieno.
        return buffer[--pos]; //decremento posizione corrente.
    }

    //prova
    int getNotSynchronized(){
        return buffer[--pos]; //decremento posizione corrente.
        //return (nCella<=lung)? buffer[nCella]: nCella; data una cella da rimuovere: bisogna spostare tutte le celle dopo.
    }
    
    boolean state(){
        return (pos==0)?true:false; //true = empty, false = not empty.
    }
}

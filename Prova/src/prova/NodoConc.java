package prova;

public class NodoConc<T> {
    protected T info;
    protected NodoConc<T> succ;
    public NodoConc(T info){
        this.info=info;
        succ=null;
    }
    public NodoConc(T info, NodoConc succ){
        this.info=info;
        this.succ=succ;
    }
}

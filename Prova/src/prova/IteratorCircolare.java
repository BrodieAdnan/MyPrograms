package prova;

import java.util.Iterator;

public class IteratorCircolare<T> implements Iterator {
    protected NodoConc<T> tail, corrente;
    public IteratorCircolare(NodoConc tail){
        corrente=this.tail=tail;
    }
    @Override
    public boolean hasNext() {
        return (corrente.succ!=tail);
    }

    @Override
    public T next() {
        T info=corrente.info;
        corrente=corrente.succ;
        return info;
    }
    
}

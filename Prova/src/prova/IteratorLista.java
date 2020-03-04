package prova;

import java.util.Iterator;

public class IteratorLista<T> implements Iterator {

    protected NodoConc<T> corrente;

    public IteratorLista(NodoConc<T> testa) {
        corrente = testa;
    }

    @Override
    public boolean hasNext() {
        return (corrente.succ != null);
    }

    @Override
    public T next() {//return elemento poi scorre.
        T info = corrente.info;
        corrente = corrente.succ;
        return info;
    }

}

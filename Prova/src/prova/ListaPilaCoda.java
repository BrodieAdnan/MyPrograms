package prova;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ListaPilaCoda<T> implements Pila<T>, Coda<T> {

    protected NodoConc<T> head;
    protected NodoConc<T> tail;
    protected int dimensione;

    public int lunghezza() {
        return dimensione;
    }

    public void addToPos(T info, int pos) {//inserimento
        if (pos >= dimensione) {
            addToTail(info);
        } else if (pos <= 0 || head == null) {
            addToHead(info);
        } else {
            NodoConc<T> corrente = head, precedente = null;
            for (; corrente != null && pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            precedente.succ = new NodoConc(info, corrente);
        }
    }

    private void addToHead(T info) {//aggiungi in testa
        if (head == null) {
            head = new NodoConc(info);
        } else {
            head = new NodoConc(info, head);
        }
    }

    private void addToTail(T info) {//aggiungi in coda
        if (tail == null) {
            tail = new NodoConc(info);
        } else {
            tail.succ = new NodoConc(info);
        }
    }

    public T estract(int pos) throws Exception {//cancellado
        if (pos < 0 || pos >= dimensione) {
            throw new Exception("Non puoi rimuovere da quà!");
        } else {
            NodoConc<T> corrente = head, precedente = null;
            T info = null;
            for (; corrente != null && pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            info = corrente.info;
            if (corrente != null) {
                if (precedente == null) {
                    corrente = corrente.succ;
                } else {
                    precedente.succ = corrente.succ;
                }
            }
            return info;
        }
    }

    @Override
    public void enqueue(T info
    ) {//aggiunge in testa
        addToHead(info);
    }

    @Override
    public T popHead() {//rimuove e estrae in testa
        try {
            return estract(0);
        } catch (Exception ex) {
            Logger.getLogger(ListaPilaCoda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    @Override
    public void dequeue(T info) {//aggiunge in coda
        addToTail(info);
    }

    @Override
    public T popTail() {//rimuove e estrae in coda
        try {
            return estract(dimensione);
        } catch (Exception ex) {
            Logger.getLogger(ListaPilaCoda.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}

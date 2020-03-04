package prova;

public class ListaCircolareHeader<T> {

    protected T info;
    protected NodoConc<T> tail;
    private int dimensione;
    protected NodoConc<T> header;

    public ListaCircolareHeader() {
        tail = header = new NodoConc("pippo", header);
    }

    public int lunghezza() {
        return dimensione;
    }

    public void addToHead(T info) {
        NodoConc<T> temp = new NodoConc(info);
        if (tail == header) {//lista vuota
            tail = new NodoConc(info, header);
            header.succ = tail;
        } else {
            temp.succ = header.succ;
            header.succ = temp;
        }
        dimensione++;
    }

    public void addToTail(T info) {
        NodoConc<T> temp = new NodoConc(info);
        if (tail == header) {
            tail = new NodoConc(info, header);
            header.succ = tail;
        } else {
            temp.succ = header;
            tail.succ = temp;
            tail = tail.succ;
        }
        dimensione++;
    }

    public void addToPos(T info, int pos) {
        NodoConc<T> corrente = header.succ, precedente = header, temp = new NodoConc(info);
        if (pos < 0 || pos > dimensione) {//inserimento in coda.
            addToTail(info);
        } else if (tail == header) {//lista vuota.
            tail = new NodoConc(info, header);
            header.succ = tail;
            dimensione++;
        } else {
            for (; pos > 0 && corrente != header; pos--, precedente = corrente, corrente = corrente.succ);
            if (precedente == header) {
                addToHead(info);
            } else if (corrente == header) {
                addToTail(info);
            } else {
                precedente.succ = temp;
                temp.succ = corrente;
                dimensione++;
            }
        }
    }

    public void remToHead() {
        if (tail != header) {
            NodoConc<T> corrente = header.succ;
            header.succ = corrente.succ;
        }
    }

    public void remToTail() {
        if (tail != header) {
            NodoConc<T> corrente = header.succ, precedente = header;
            for (; corrente != tail; precedente = corrente, corrente = corrente.succ);
            precedente.succ=header;
        }
    }
    
    public void remToPos(int pos){
        if (true) {
            
        }
    }
}

package prova;

public class ListaCircolare<T> {

    protected T info;
    protected NodoConc<T> tail;
    private int dimensione;

    public ListaCircolare() {
        tail = new NodoConc(null, tail);
    }

    public void addToHead(T info) {
        if (tail == null) {
            tail = new NodoConc(info, tail);
        } else {
            NodoConc<T> temp = new NodoConc(info);
            temp.succ = tail.succ;
            tail = temp;
        }
        dimensione++;
    }

    public void addToPos(T info, int pos) {
        if (tail == null) {
            tail = new NodoConc(info, tail);
            dimensione++;
        } else if (pos < 0 || pos >= dimensione) {
            addToTail(info);
        } else {
            NodoConc<T> corrente = tail.succ;
            NodoConc<T> precedente = tail;
            for (; pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            NodoConc<T> temp = new NodoConc(info);
            temp.succ = corrente;
            precedente.succ = temp;
            dimensione++;
        }
    }

    public void addToTail(T info) {
        addToHead(info);
        tail = tail.succ;
    }

    public int lunghezza() {
        return dimensione;
    }

    public void remToHead() throws Exception {
        if (tail == null) {
            throw new Exception("Impossibile rimuovere da lista vuota!");
        } else {
            NodoConc<T> head = tail.succ;
            tail.succ = head.succ;
        }
    }

    public void remToTail() throws Exception {
        if (tail == null) {
            throw new Exception("Impossibile rimuovere da lista vuota!");
        } else {
            NodoConc<T> precedente = tail, corrente = tail.succ;
            for (; corrente != tail; precedente = corrente, corrente = corrente.succ);
            precedente.succ = corrente.succ;
        }
    }

    public void remToPos(int pos) throws Exception {
        if (tail == null) {
            throw new Exception("Impossibile rimuovere da lista vuota!");
        } else if (pos < 0 || pos >= dimensione) {
            remToTail();
        } else {
            NodoConc<T> precedente = tail, corrente = tail.succ;
            for (; pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            precedente.succ = corrente.succ;
        }
    }

    public T estract(int pos) throws Exception {//and remove.
        T info = null;
        if (tail == null) {
            throw new Exception("Impossibile rimuovere da lista vuota!");
        } else {
            NodoConc<T> corrente = tail.succ, precedente = tail;
            for (; pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            info = corrente.info;
            precedente.succ = corrente.succ;
        }
        return info;

    }

    public boolean search(T info) {
        NodoConc<T> corrente = tail.succ, precedente = tail;
        boolean trovato = false;
        if (tail != null) {
            for (; corrente != tail; precedente = corrente, corrente = corrente.succ) {
                if (corrente.info.equals(info)) {
                    trovato = true;
                }
            }
        }
        return trovato;
    }

    public T nodoPos(int pos) {
        NodoConc<T> corrente = tail.succ;
        for (; corrente != null && pos > 0; pos--, corrente = corrente.succ);
        return corrente.info;
    }
}

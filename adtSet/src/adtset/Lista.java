package adtset;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lista<T> implements Set<T> {

    protected NodoConc<T> head;
    protected int dimensione;

    public T estract(int pos) throws Exception {//senza cancellare.
        T info = null;
        if (pos < 0 || pos > dimensione) {
            throw new Exception("Impossibile estrarre da questa posizione!");
        } else if (head == null) {
            info = null;
        } else {
            NodoConc<T> corrente = head;
            for (; corrente != null && pos > 0; pos--, corrente = corrente.succ);
            info = corrente.info;
        }
        return info;
    }

    public void addToHead(T info) {
        if (head == null) {
            head = new NodoConc(info);
        } else {
            NodoConc<T> temp = new NodoConc(info);
            temp.succ = head;
            head = temp;
        }
        dimensione++;
    }

    public void addToTail(T info) {
        if (head == null) {
            head = new NodoConc(info);
        } else {
            NodoConc<T> corrente = head, precedente = null;
            for (; corrente != null; precedente = corrente, corrente = corrente.succ);
            precedente.succ = new NodoConc(info);
        }
        dimensione++;
    }

    public void addToPos(T info, int pos) throws Exception {
        if (pos > dimensione) {//se maggiore della lunghezza, aggiunge in coda.
            addToTail(info);
        } else if (pos < 0) {
            throw new Exception("Non puoi inserire in posizione negativa!");
        } else if (head == null) {
            addToTail(info);
        } else {
            NodoConc<T> precedente = null;
            NodoConc<T> corrente = head;
            for (; corrente != null && pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            NodoConc<T> temp = new NodoConc(info);
            if (precedente == null) {
                addToHead(info);
            } else {
                temp.succ = corrente;
                precedente.succ = temp;
                dimensione++;
            }
        }
    }

    public void remToHead() throws Exception {
        if (head == null) {
            throw new Exception("Niente da rimuovere!");
        } else {
            head = head.succ;
        }
        dimensione--;
    }

    public void remToTail() throws Exception {
        if (head == null) {
            throw new Exception("Niente da rimuovere!");
        } else {
            NodoConc<T> corrente = head;
            for (; corrente != null; corrente = corrente.succ);
            corrente = null;
        }
        dimensione--;
    }

    public void remToPos(int pos) throws Exception {
        if (head == null) {
            throw new Exception("Niente da rimuovere!");
        } else if (pos > dimensione) {
            throw new Exception("Impossibile rimuovere oltre dalla lista!");
        } else {
            NodoConc<T> precedente = null;
            NodoConc<T> corrente = head;
            for (; corrente != null && pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            precedente.succ = corrente.succ;
        }
        dimensione--;
    }

    public boolean search(T info) {
        boolean trovato = false;
        NodoConc<T> corrente = head;
        for (; corrente != null; corrente = corrente.succ) {
            if (corrente.info == info) {
                trovato = true;
            }
        }
        return trovato;
    }

    public int lunghezza() {
        return dimensione;
    }

    @Override
    public boolean add(T x) {
        boolean inserito = false;
        if (!search(x)) {
            addToTail(x);
            inserito = true;
        }
        return inserito;
    }

    @Override
    public boolean remove(T x) {
        boolean eliminato = false;
        if (search(x)) {
            try {
                searchAndRem(x);
                eliminato = true;
            } catch (Exception ex) {
                Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return eliminato;
    }

    @Override
    public boolean contains(T x) {
        return search(x);
    }

    @Override
    public boolean isEmpty() {
        boolean vuoto = false;
        if (head == null) {
            vuoto = true;
        }
        return vuoto;
    }

    @Override
    public void clear() {
        head = null;
    }

    @Override
    public void union(Set x) {//insieme di tutti gli elementi presi una sola volta.
        NodoConc<T> corrente = ((Lista) (x)).head;
        for (; corrente != null; corrente = corrente.succ) {
            if (!search(corrente.info)) {
                addToTail(corrente.info);
            }
        }
    }

    @Override
    public void intersect(Set x) {//insiemi di tutti gli elementi comuni.
        NodoConc<T> corrente = ((Lista) (x)).head;
        Lista<T> temp = new Lista();
        for (; corrente != null; corrente = corrente.succ) {
            if (search(corrente.info)) {
                temp.add(corrente.info);
            }
        }
        head = temp.head;
    }

    @Override
    public void subtract(Set x) {//insieme di tutti gli elementi non presenti in x.
        NodoConc<T> corrente = ((Lista) (x)).head;
        for (; corrente != null; corrente = corrente.succ) {
            if (search(corrente.info)) {
                try {
                    searchAndRem(corrente.info);
                } catch (Exception ex) {
                    Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private void searchAndRem(T x) throws Exception {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && !corrente.info.equals(x); precedente = corrente, corrente = corrente.succ);
        if (corrente != null) {
            if (precedente == null) {
                head = head.succ;
            } else {
                precedente.succ = corrente.succ;
            }
        } else {
            throw new Exception("Elemento non trovato!");
        }
        dimensione--;
    }

    @Override
    public String toString() {
        String ris = "";
        NodoConc<T> corrente = head;
        for (; corrente != null; corrente = corrente.succ) {
            ris += corrente.info + " ";
        }
        return ris;
    }
}

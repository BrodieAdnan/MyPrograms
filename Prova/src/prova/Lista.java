package prova;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Lista<T> {//implements Clonable {

    protected NodoConc<T> head;
    protected int dimensione;

    public T estract(int pos) throws Exception {//senza cancellare.
        T info = null;
        if (pos < 0 || pos >= dimensione) {
            throw new Exception("Impossibile estrarre da questa posizione!");
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
            head = new NodoConc(info, head);
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
        if (pos >= dimensione) {//se maggiore della lunghezza, aggiunge in coda.
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
            //corrente non può essere null, perchè se no pos sarebbe fuori dalla dimensione.
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
            NodoConc<T> corrente = head, precedente = null;
            for (; corrente != null; precedente = corrente, corrente = corrente.succ);
            precedente = null;//corrente è già uguale a null.
        }
        dimensione--;
    }

    public void remToPos(int pos) throws Exception {
        if (head == null) {
            throw new Exception("Niente da rimuovere!");
        } else if (pos < 0 || pos >= dimensione) {
            throw new Exception("Impossibile rimuovere oltre la lista!");
        } else {
            NodoConc<T> precedente = null;
            NodoConc<T> corrente = head;
            for (; corrente != null && pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            if (precedente == null) {
                remToHead();
            } else {
                precedente.succ = corrente.succ;
            }
        }
        dimensione--;
    }

    public boolean search(T info) {
        boolean trovato = false;
        if (head != null) {
            NodoConc<T> corrente = head;
            for (; corrente != null; corrente = corrente.succ) {
                if (corrente.info.equals(info)) {
                    trovato = true;
                }
            }
        }
        return trovato;
    }

    public int lunghezza() {
        return dimensione;
    }

//    @Override
//    public ListaPilaCoda simpleClone() {
//        try {
//            return (ListaPilaCoda) super.clone();
//        } catch (CloneNotSupportedException ex) {
//            Logger.getLogger(Lista.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return null;
//    }
//    @Override
//    public ListaPilaCoda intermediateClone() {
//        ListaPilaCoda<T> t = new ListaPilaCoda();
//        NodoConc<T> corrente = head.succ;
//        if (head != null) {
//            t.head = new NodoConc(head.info);
//            t.tail = t.head;
//            for (; corrente != null; corrente = corrente.succ) {
//                t.tail.succ = new NodoConc(corrente.info);
//            }
//            t.dimensione = dimensione;
//        }
//        return t;
//    }
//    @Override
//    public ListaPilaCoda deepClone() {
//        ListaPilaCoda<T> t = new ListaPilaCoda();
//        NodoConc<T> corrente = head.succ;
//        if (head != null) {
//            t.head = new NodoConc(head.info.clone());
//            t.tail = t.head;
//            for (; corrente != null; corrente = corrente.succ) {
//                t.tail.succ = new NodoConc(corrente.info.clone());
//            }
//            t.dimensione = dimensione;
//        }
//        return t;
//    }
}

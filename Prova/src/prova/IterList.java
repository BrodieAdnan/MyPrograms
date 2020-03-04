package prova;

import java.util.Iterator;

public class IterList<T> extends Lista<T> {//estende Lista e utilizza iteratorLista per estendere metodi.

    protected IteratorLista<Iterator> it = new IteratorLista(head);

    public boolean successivo(int pos) {
        NodoConc<T> corrente = head;
        for (; corrente != null && pos > 0; pos--, corrente = corrente.succ);
        return (!corrente.succ.equals(null));
    }

    public T elemSucc(int pos) {
        NodoConc<T> corrente = head;
        for (; corrente != null && pos >= 0; pos--, corrente = corrente.succ);
        return corrente.info;
    }

    public T elemPos(int pos) {
        NodoConc<T> corrente = head;
        for (; corrente != null && pos > 0; pos--, corrente = corrente.succ);
        return corrente.info;
    }

    public T elemPrec(int pos) {
        NodoConc<T> corrente = head;
        for (; corrente != null && pos > 1; pos--, corrente = corrente.succ);
        return corrente.info;
    }

    public void remPrec(int pos) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && pos > 1; pos--, precedente = corrente, corrente = corrente.succ);
        precedente.succ = corrente.succ;
    }

    public T estractAndRem(int pos) throws Exception {
        T info;
        if (pos < 0 || pos > dimensione) {
            throw new Exception("Impossibile estrarre da questa posizione!");
        } else if (head == null) {
            info = null;
        } else {
            NodoConc<T> corrente = head, precedente = null;
            for (; corrente != null && pos > 0; pos--, precedente = corrente, corrente = corrente.succ);
            info = corrente.info;
            precedente.succ = corrente.succ;
        }
        return info;
    }

    public T estractAndRemPrec(int pos) throws Exception {
        T info;
        if (pos < 0 || pos > dimensione) {
            throw new Exception("Impossibile estrarre da questa posizione!");
        } else if (head == null) {
            info = null;
        } else {
            NodoConc<T> corrente = head, precedente = null;
            for (; corrente != null && pos > 1; pos--, precedente = corrente, corrente = corrente.succ);
            info = corrente.info;
            precedente.succ = corrente.succ;
        }
        return info;
    }

    public T estractAndRemSucc(int pos) throws Exception {
        T info;
        if (pos < 0 || pos > dimensione) {
            throw new Exception("Impossibile estrarre da questa posizione!");
        } else if (head == null) {
            info = null;
        } else {
            NodoConc<T> corrente = head, precedente = null;
            for (; corrente != null && pos >= 0; pos--, precedente = corrente, corrente = corrente.succ);
            info = corrente.info;
            precedente.succ = corrente.succ;
        }
        return info;
    }

    public void remSucc(int pos) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && pos >= 0; pos--, precedente = corrente, corrente = corrente.succ);
        precedente.succ = corrente.succ;
    }

    public T searchPrec(T info) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && !corrente.info.equals(info); precedente = corrente, corrente = corrente.succ);
        return precedente.info;
    }

    public T searchSucc(T info) {
        NodoConc<T> corrente = head;
        for (; corrente != null && !corrente.info.equals(info); corrente = corrente.succ);
        return corrente.succ.info;
    }

    public boolean thereIsSucc(T info) {
        NodoConc<T> corrente = head;
        for (; corrente != null && !corrente.info.equals(info); corrente = corrente.succ);
        boolean succ = false;
        if (corrente.succ != null) {
            succ = true;
        }
        return succ;
    }

    public void rPrec(T info) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && !corrente.info.equals(info); precedente = corrente, corrente = corrente.succ);
        NodoConc<T> iniziale = new NodoConc(searchPrec(precedente.info));
        iniziale.succ = precedente.succ;
    }

    public void rSucc(T info) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && !corrente.info.equals(info); precedente = corrente, corrente = corrente.succ);
        precedente = corrente;
        corrente = corrente.succ;
        precedente.succ = corrente.succ;
    }

    public T estractRSucc(T info) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && !corrente.info.equals(info); precedente = corrente, corrente = corrente.succ);
        precedente = corrente;
        corrente = corrente.succ;
        T elem = corrente.info;
        precedente.succ = corrente.succ;
        return elem;
    }

    public T estractRPrec(T info) {
        NodoConc<T> corrente = head, precedente = null;
        for (; corrente != null && !corrente.info.equals(info); precedente = corrente, corrente = corrente.succ);
        NodoConc<T> iniziale = new NodoConc(searchPrec(precedente.info));
        T elem = precedente.info;
        iniziale.succ = precedente.succ;
        return elem;
    }

    public void cancCont() {
        NodoConc<T> corrente = head, inizio = head, fine = head, precedente = null;
        boolean aperta = false;
        for (; corrente != null; precedente = corrente, corrente = corrente.succ) {
            if (corrente.info.equals('(') && !aperta) {
                inizio = precedente;
                aperta = true;
            } else if (corrente.info.equals(')')) {
                fine = corrente;
            }
        }
        inizio.succ = fine.succ;
    }

    public void cancContenuto() {
        NodoConc<T> corrente = head, inizio = head, fine = head;
        int pos = 0;
        for (; !elemSucc(pos).equals('('); pos++, corrente = corrente.succ);
        inizio = corrente;
        for (; corrente != null; corrente = corrente.succ) {
            if (corrente.info.equals(')')) {
                fine = corrente;
            }
        }
        inizio.succ = fine.succ;
    }

    public void cancContIt() {
        IteratorLista<Iterator> i = new IteratorLista(head);
        NodoConc<T> inizio = null, fine = null, corrente = head, temp, precedente;
        boolean aperta = false;
        while (i.hasNext()) {
            precedente = corrente;
            corrente = corrente.succ;
            temp = new NodoConc(i.next());
            if (temp.info.equals('(') && !aperta) {
                inizio = precedente;
                aperta = true;
            } else if (temp.info.equals(')')) {
                fine = corrente;
            }
        }
        inizio.succ = fine.succ;
    }

    public boolean containsAll(Lista l) {
        NodoConc<T> corrente = head;
        boolean contains = true;
        for (; corrente != null; corrente = corrente.succ) {
            if (!search(corrente.info)) {
                contains = false;
            }
        }
        return contains;
    }

    public T[] toArray() {
        Object[] arr = new Object[dimensione];
        int pos = 0;
        IteratorLista<Iterator> i = new IteratorLista(head);
        while (i.hasNext()) {
            arr[pos++] = i.next();
        }
        return (T[]) arr;
    }

    public boolean containsAllIt(Lista l) {
        IteratorLista<Iterator> i = new IteratorLista(head);
        boolean contains = true;
        NodoConc<T> corrente = head;
        while (i.hasNext()) {
            if (!search((i.next()))) {
                contains = false;
            }
        }
        return contains;
    }

    public T[] toArrayIt() {
        Object[] arr = new Object[dimensione];
        NodoConc<T> corrente = head;
        for (int pos = 0; corrente != null; pos++, corrente = corrente.succ) {
            arr[pos] = corrente.info;
        }
        return (T[]) arr;
    }

    public ListaPilaCoda simpleClone() throws CloneNotSupportedException {
        return (ListaPilaCoda) super.clone();
    }

    public ListaPilaCoda intermediateClone() {
        NodoConc<T> corrente = head.succ;
        ListaPilaCoda<T> l = new ListaPilaCoda();
        if (head != null) {
            l.head = new NodoConc(head.info);
            l.tail = head;
            for (; corrente != null; corrente = corrente.succ) {
                l.tail.succ = new NodoConc(corrente.info);
                l.tail = l.tail.succ;
            }
            l.dimensione = dimensione;
        }
        return l;
    }

    public ListaPilaCoda deepClone() {
        NodoConc<T> corrente = head.succ;
        ListaPilaCoda<T> l = new ListaPilaCoda();
        if (head != null) {
            l.head = new NodoConc(head.info.clone());
            l.tail = head;
            for (; corrente != null; corrente = corrente.succ) {
                l.tail.succ = new NodoConc(corrente.info.clone());
                l.tail = l.tail.succ;
            }
            l.dimensione = dimensione;
        }
        return l;
    }

    public ListaPilaCoda simpleCloneIt() throws CloneNotSupportedException {
        return (ListaPilaCoda) super.clone();
    }

    public ListaPilaCoda intermediateCloneIt() {
        IteratorLista<Iterator> i = new IteratorLista(head);
        ListaPilaCoda<T> l = new ListaPilaCoda();
        if (i.hasNext()) {
            l.head = new NodoConc(i.next());
            l.tail = head;
            while (i.hasNext()) {
                l.tail.succ = new NodoConc(i.next());
                l.tail = l.tail.succ;
            }
            l.dimensione = dimensione;
        }
        return l;
    }

    public ListaPilaCoda deepCloneIt() {
        IteratorLista<Iterator> i = new IteratorLista(head);
        ListaPilaCoda<T> l = new ListaPilaCoda();
        if (i.hasNext()) {
            l.head = new NodoConc(i.next().clone());
            l.tail = head;
            while (i.hasNext()) {
                l.tail.succ = new NodoConc(i.next().clone());
                l.tail = l.tail.succ;
            }
            l.dimensione = dimensione;
        }
        return l;
    }

    public Lista[] pariDispari() {
        NodoConc<T> corrente = head;
        Lista<T>[] n = new Lista[]{new Lista(), new Lista()};
        for (; corrente != null; corrente = corrente.succ) {
            if (corrente.info % 2 == 0) {
                if (n[0].head == null) {
                    n[0].head = corrente;
                } else {
                    n[0].head.succ = corrente;
                }
            } else {
                if (n[1].head == null) {
                    n[1].head = corrente;
                } else {
                    n[1].head.succ = corrente;
                }
            }
        }
        return n;
    }

    public Lista[] pariDispariIt() {
        IteratorLista<Iterator> i = new IteratorLista(head);
        NodoConc<T> corrente = null;
        Lista<T>[] n = new Lista[]{new Lista(), new Lista()};
        while (i.hasNext()) {
            corrente = new NodoConc(i.next());
            if (corrente % 2 == 0) {
                if (n[0].head == null) {
                    n[0].head = corrente;
                } else {
                    n[0].head.succ = corrente;
                }
            } else {
                if (n[1].head == null) {
                    n[1].head = corrente;
                } else {
                    n[1].head.succ = corrente;
                }
            }
        }
        return n;
    }
}

package adtset;

public interface Set<T> {
    //aggiunge x alla coda della lista solo nel caso in cui non sia già presente.
    public boolean add(T x);
    //rimuove un elemento uguale a x solo nel caso in cui sia presente.
    public boolean remove(T x);
    //true se x è già presente.
    public boolean contains(T x);
    //true se lista è vuota.
    public boolean isEmpty();
    //nuova lista vuota.
    public void clear();
    //aggiunge alla lista gli elementi di x non presenti nella lista.
    public void union(Set x);
    //elementi comuni sia alla lista che a x.
    public void intersect(Set x);
    //elementi presenti nella lista ma non in x.
    public void subtract(Set x);
    
    @Override
    public String toString();
}

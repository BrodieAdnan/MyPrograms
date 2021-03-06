package scrivi;

/**
 * ********************************
 * ARRAYLOGICO
 *
 * @author Gazi Adnan Latif
 * @brief vettore ridimensionabile.
 * @date 11/04/2017
 **********************************
 */
public class ArrayLogico { //al posto di tutti gli Object mettere il tipo specifico delle posizioni del vettore.

    private Object[] array;
    private int dim;
    private int step;
    private int length;

    public ArrayLogico(int dim, int step) {
        this.dim = dim;
        this.step = step;
        array = new Object[this.dim];
    }

    public ArrayLogico(int dim) {
        this(dim, 1);
    }

    public ArrayLogico() {
        this(10, 1);
    }

    public int getLength() {
        return length;
    }

    public int getDim() { //restituisce la lunghezza attuale dell'array.
        return dim;
    }

    public Object get(int pos) { //restituisce elemento in pos.
        if (pos >= 0 && pos < dim) {
            return array[pos];
        } else {
            throw new ArrayIndexOutOfBoundsException("Indice dell'array sbagliato nel 'get'");
        }
    }

    public void set(int pos, Object valore) { //inserisce in pos, l'elemento passato.
        if (pos >= 0 && pos < dim) {
            array[pos] = valore;
        } else {
            throw new ArrayIndexOutOfBoundsException("Indice dell'array sbagliato nel 'set'");
        }
    }

    public void add(Object valore) { //chiamato quando finiscono le posizioni.
        length = dim;
        Object[] temp = new Object[dim + step];
        for (int i = 0; i < dim; i++) {
            temp[i] = array[i];
        }
        array = temp;
        dim += step;
        array[length] = valore;

        length++;
    } //aggiunge step posizioni e mette nella prima aggiunta l'elemento passato.

    public Object remove(int pos) { //rimuove pos elementi dalla fine del vettore.
        Object val = "";
        if (pos >= 0 && pos < dim) {
            val = array[pos];
            for (int i = pos + 1; i < length; i++) {
                array[i - 1] = array[i];
            }
            length--;
            if (dim - length > step + step / 2) {
                Object[] temp = new Object[dim - step];
                for (int i = 0; i < length; i++) {
                    temp[i] = array[i];
                }
                array = temp;
                dim -= step;
            }
            return val;
        }
        throw new ArrayIndexOutOfBoundsException("Remove sbagliato");
    }
}

package gestionearraylogico;

/**
 * ********************************
 * ARRAYLOGICO
 *
 * @author Gazi Adnan Latif
 * @brief vettore ridimensionabile.
 * @date 26/04/2017
 * ********************************
 */
public class ArrayLogico {

    private int[] array;
    private int dim;
    private int step;
    private int length;

    public ArrayLogico(int dim, int step) { //costruttore principale.
        this.dim = dim;
        this.step = step;
        array = new int[this.dim];
    }

    public ArrayLogico(int dim) {
        this(dim, 4);
    }

    public ArrayLogico() {
        this(10, 4);
    }

    public int getLength() { //restituisce l'ultima posizione dove è presente un elemento.
        return length;
    }

    public int getDim() { //restituisce la lunghezza attuale dell'array.
        return dim;
    }

    public int get(int pos) { //restituisce elemento in pos.
        if (pos >= 0 && pos < dim) {
            return array[pos];
        } else {
            throw new ArrayIndexOutOfBoundsException("Indice dell'array sbagliato nel 'get'");
        }
    }

    public void set(int pos, int valore) { //inserisce in pos l'elemento.
        if (pos >= 0 && pos < dim) {
            array[pos] = valore;
        } else {
            throw new ArrayIndexOutOfBoundsException("Indice dell'array sbagliato nel 'set'");
        }
    }

    public void add(int valore) { //chiamato quando finiscono le posizioni.
        length = dim;

        int[] temp = new int[dim + step];
        for (int i = 0; i < dim; i++) {
            temp[i] = array[i];
        }
        array = temp;
        dim += step;
        array[length] = valore;

        length++;
    } //aggiunge step posizioni e mette nella prima aggiunta l'elemento passato.

    public int remove(int pos) { //rimuove la pozione indicata con il suo valore.
        int val = 0;
        if (pos >= 0 && pos < dim) {
            val = array[pos];
            for (int i = pos + 1; i < dim; i++) {
                array[i - 1] = array[i];
            }
            dim--;
            if (dim - length > step + step / 2) {
                int[] temp = new int[dim - step];
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

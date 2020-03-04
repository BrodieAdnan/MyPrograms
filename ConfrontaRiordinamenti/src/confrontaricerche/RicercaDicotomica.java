package confrontaricerche;

import java.util.logging.*;
import java.util.Arrays;

public class RicercaDicotomica extends Thread {

    private int[] v;
    private int[] elem;
    private boolean[] ris;
    private Cronometro c;
    private int[] nRipetizioni;

    public RicercaDicotomica(String nome, int[] v, int[] elem, Cronometro c) {
        super(nome);
        this.v = v;
        this.c = c;
        this.elem = elem;
        ris = new boolean[elem.length];
        nRipetizioni = new int[elem.length];
    }

    @Override
    public void run() {
        c.start();//partenza cronometro
        for (int i = 0; i < ris.length; i++) {
            ris[i] = false;
            nRipetizioni[i] = 0;
        }
        //utilizzo : mergeSort();
        Arrays.sort(v);
        ricerca();
        c.stop();
        System.out.println("Ricerca Dicotomica dell'elemento finito in : " + c.getTime());
        c.reset();
    }

    private void ricerca() {

        for (int i = 0; i < elem.length; i++) {
            int d = v.length / 2;
            ThreadDicotomico thread1 = new ThreadDicotomico("1", 0, d, elem[i], ris, v, i, nRipetizioni);
            ThreadDicotomico thread2 = new ThreadDicotomico("2", d, v.length, elem[i], ris, v, i, nRipetizioni);
            thread1.start();
            thread2.start();
            try {//thread RicercaDicotomica wait thread1 & thread2
                thread1.join();
                thread2.join();

            } catch (InterruptedException ex) {
                Logger.getLogger(RicercaDisordinata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void quickSort(int[] arr, int low, int high) {
        if (arr == null || arr.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }
        int middle = low + (high - low) / 2;
        int pivot = arr[middle];
        int i = low, j = high;
        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(arr, i, j);
                i++;
                j--;
            }
        }
        if (low < j) {
            quickSort(arr, low, j);
        }
        if (high > i) {
            quickSort(arr, i, high);
        }
    }

    public void swap(int array[], int x, int y) {
        int temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }

    //mergeSort non usato!
    public void mergeSort(int[] array, int min, int max) {

        if ((max - min) < 20) {
            insertionSort(array, min, max);
        } else {
            int medio = (min + max) / 2;    // Trovo l' indice per suddividere il vettore
            mergeSort(array, min, medio); // Primo sotto-vettore
            mergeSort(array, medio + 1, max); // Secondo sotto-vettore
            merge(array, min, medio, max); // Fondo i due sotto-vettori
        }
    }

    // Questo metodo fonde i due sotto-vettori ordinati, in un unico vettore ordinato
    public void merge(int[] array, int min, int med, int max) {
        int[] a = new int[max - min + 1];
        int i1 = min;
        int i2 = med + 1;
        int i3 = 1;
        for (; (i1 <= med) && (i2 < max); i3++) {
            if (array[i2] > array[i1]) {
                a[i3] = array[i1];
                i1++;
            } else {
                a[i3] = array[i2];
                i2++;
            }
        }
        for (; i1 <= med; i1++, i3++) {
            a[i3] = array[i1];
        }
        for (; i2 < max; i2++, i3++) {
            a[i3] = array[i2];
        }
        for (i3 = 1, i1 = min; i1 < max; i1++, i3++) {
            array[i1] = a[i3];
        }
    }

    /**
     * Questo é l' Insertion Sort, che abbiamo giá visto, con uan sola
     * differenza ci permette di ordinare una porzione di vettore che va da min
     * a max *
     */
    public void insertionSort(int[] array, int min, int max) {
        for (int i = min + 1; i < max; i++) {
            int x = i;
            int j = i - 1;
            for (; j >= min; j--) {
                if (array[j] > array[x]) {
                    int k = array[x];
                    array[x] = array[j];
                    array[j] = k;
                    x = j;
                } else {
                    break;
                }
            }
        }
    }
    //fine mergeSort non usato!

    //bubble sort non utilizzato!
    void bubbleSort(int[] array, int elemN) {
        int alto;
        for (alto = elemN - 1; alto > 0; alto--) {
            for (int i = 0; i < alto; i++) {
                if (array[i] > array[i + 1]) /* sostituire ">" con "<" per avere un ordinamento decrescente */ {
                    int tmp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = tmp;
                }
            }
        }
    }
    //fine bubble sort non utilizzato!

    //sequential sort non utilizzato!
    void sequentialSort(int[] V) {
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v.length; j++) {
                if (v[j] > v[i]) {
                    int temp = v[i];
                    v[i] = v[j];
                    v[j] = temp;
                }
            }
        }
    }
    //fine sequential sort non utilizzato!
}

package confrontaricerche;

import java.util.Arrays;

public class ThreadDicotomico extends Thread {

    private int elem, inizio, fine, pos;
    private boolean[] ris;
    private int[] v, rip;

    public ThreadDicotomico(String nome, int inizio, int fine, int e, boolean[] ris, int[] v, int pos, int[] rip) {
        super(nome);
        this.elem = e;
        this.ris = ris;
        this.v = v;
        this.inizio = inizio;
        this.fine = fine;
        this.pos = pos;
        this.rip = rip;
    }

    @Override
    public void run() {
        if (Arrays.binarySearch(v, elem) == 1) {
            ris[pos] = true;
            rip[pos]++;
        }
//metodo di ricerca binaria non utilizzata.
//        int centro;
//        boolean bool=true;
//        while (inizio < fine && bool) {
//            centro = (inizio + fine) / 2;
//            if (v[centro] == elem) {
//                
//                bool=false;
//            } else if (v[centro] > elem) {
//                fine = centro;
//            } else {
//                inizio = centro+1;
//            }
//        }
    }
}

package confrontaricerche;

import java.util.logging.*;

public class RicercaDisordinata extends Thread {

    private int[] v;//vettore su cui cercare
    private int[] elem;
    private boolean[] ris;
    private Cronometro c;
    private int[] nRipetizioni;

    public RicercaDisordinata(String nome, int[] v, int[] elem, Cronometro c) {
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

        ricerca();
        c.stop();
        System.out.println("Ricerca Disordinata dell'elemento finito in : " + c.getTime());
        c.reset();
    }

    private void ricerca() {
        for (int i = 0; i < elem.length; i++) {

            int d = v.length / 2;
            ThreadDisordinata thread1 = new ThreadDisordinata("1", 0, d, elem[i], ris, v, i, nRipetizioni);
            ThreadDisordinata thread2 = new ThreadDisordinata("2", d, v.length, elem[i], ris, v, i, nRipetizioni);
            thread1.start();
            thread2.start();
            try {//thread RicercaDisordinata wait thread1 & thread2
                thread1.join();
                thread2.join();

            } catch (InterruptedException ex) {
                Logger.getLogger(RicercaDisordinata.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

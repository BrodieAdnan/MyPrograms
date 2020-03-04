package confrontaricerche;

public class ThreadDisordinata extends Thread {

    private int inizio, fine, elem, pos;
    private boolean[] ris;
    private int[] v, rip;

    public ThreadDisordinata(String nome, int inizio, int fine, int e, boolean[] ris, int[] v, int pos, int[] rip) {
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
        boolean bool = true;
        for (; inizio < fine && bool; inizio++) {
            if (v[inizio] == elem) {
                ris[pos] = true;
                rip[pos]++;
            }
        }
    }
}

package confrontaricerche;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ConfrontaRicerche {

    static int[] vDic;//vettore su cui eseguire la ricerca dicotomica
    static int[] vDis;//vettore su cui eseguire la ricerca disordinata
    static int[] elem;//vettori di elementi comuni
    static Cronometro dic = new Cronometro();
    static Cronometro dis = new Cronometro();

    public static void main(String[] args) {
        riempi();
        RicercaDisordinata disordinata = new RicercaDisordinata("Ricerca Disordinata", vDis, elem, dis);
        RicercaDicotomica dicotomica = new RicercaDicotomica("Ricerca Dicotomica", vDic, elem, dic);
        disordinata.start();
        dicotomica.start();
        try {//thread main wait ricercaDicotomica & ricercaDisordinata
            disordinata.join();
            dicotomica.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(RicercaDisordinata.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("Fine thread main, fine programma!");
    }

    public static void riempi() {
        vDic = new int[1000000];
        vDis = new int[vDic.length];
        elem = new int[1000];
        //riempio il vettore di elementi con numeri casuali.
        for (int i = 0; i < elem.length; i++) {
            elem[i] = (int) (Math.random() * 1000);
        }
        //riempio il vettore in cui cercare di numeri casuali, e li assegno all'altro vettore.
        for (int i = 0; i < vDic.length; i++) {
            vDic[i] = (int) (Math.random() * 1000);
            vDis[i] = vDic[i];
        }
    }
}

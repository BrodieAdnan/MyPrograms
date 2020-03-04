package tempo;
/**
 ***************************************************
 * DIGIT
 *
 * @author Adnan Gazi Latif
 * @brief gestisce il disegno delle cifre.
 * @date 11/04/2017
 ***************************************************
 */
public class Digit {

    private double lato;
    private double iniziale;
    private Linea[] lati;

    private boolean[][] nAbbinamenti = {
        // a     b     c     d     e     f     g 
        {true, true, true, true, true, true, false}, //0
        {false, true, true, false, false, false, false}, //1
        {true, true, false, true, true, false, true}, //2
        {true, true, true, true, false, false, true}, //3
        {false, true, true, false, false, true, true}, //4
        {true, false, true, true, false, true, true}, //5
        {true, false, true, true, true, true, true}, //6
        {true, true, true, false, false, false, false}, //7
        {true, true, true, true, true, true, true}, //8
        {true, true, true, true, false, true, true} //9
    };

    public Digit(double l, double x) {
        lato = l;
        iniziale = x;
        Punto[] punti = {
            new Punto(iniziale, 0.7),
            new Punto(iniziale + lato/2, 0.7),
            new Punto(iniziale + lato/2, 0.7 - lato),
            new Punto(iniziale + lato/2, 0.7 - (lato * 2)),
            new Punto(iniziale, 0.7 - (lato * 2)),
            new Punto(iniziale, 0.7 - lato)};
        lati = new Linea[7];
        lati[0] = new Linea(punti[0], punti[1]);
        lati[1] = new Linea(punti[1], punti[2]);
        lati[2] = new Linea(punti[2], punti[3]);
        lati[3] = new Linea(punti[3], punti[4]);
        lati[4] = new Linea(punti[4], punti[5]);
        lati[5] = new Linea(punti[5], punti[0]);
        lati[6] = new Linea(punti[5], punti[2]);
    }

    public void disegnaNumero(int n) {
        for (int i = 0; i < 7; i++) {
            if (nAbbinamenti[n][i]) {
                lati[i].disegnaLinea();
            }
        }
    }
}

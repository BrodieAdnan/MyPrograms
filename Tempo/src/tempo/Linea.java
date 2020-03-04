package tempo;
/**
 ***************************************************
 * LINEA
 * 
 * @author Adnan Gazi Latif
 * @brief gestisce le linee di ogni digit.
 * @date 11/04/2017
 ***************************************************
 */
import static zuclib.GraficaSemplice.*;

public class Linea {

    private Punto p1;
    private Punto p2;

    public Linea(Punto p1, Punto p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public void disegnaLinea() {
        linea(p1.getX(), p1.getY(), p2.getX(), p2.getY(), BIANCO, 0.01);
    }
}

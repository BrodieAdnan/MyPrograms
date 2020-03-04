package tempo;
/**
 ***************************************************
 * PUNTO
 *
 * @author Adnan Gazi Latif
 * @brief gestisce i punti del disegno.
 * @date 11/04/2017
 ***************************************************
 */
public class Punto {

    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
}

package decorazionequadratocerchio;

import java.util.*;
import static zuclib.GraficaSemplice.*;

/**
 * @author adnan.gazi
 */
public class DecorazioneQuadratoCerchio {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double lato = 0.99;
        System.out.println("inserisci il numero : ");
        int n = 2 * input.nextInt();
        double x = 0.5;
        double y = 0.5;
        setFinestra(900, 900, "salve");
        ricorsione1(lato, n, x, y);
    }

    public static void ricorsione1(double lato, int n, double x, double y) {
        if (n >= 0) {
            quadratoPieno(x, y, lato, GIALLO);
            quadrato(x, y, lato);
            ricorsione2(lato / 4, n - 1, x - lato / 4, y + lato / 4);
            ricorsione2(lato / 4, n - 1, x + lato / 4, y + lato / 4);
            ricorsione2(lato / 4, n - 1, x + lato / 4, y - lato / 4);
            ricorsione2(lato / 4, n - 1, x - lato / 4, y - lato / 4);
        }
    }

    public static void ricorsione2(double lato, int n, double x, double y) {
        if (n >= 0) {
            cerchioPieno(x, y, lato, BLU);
            cerchio(x, y, lato);
            ricorsione1((lato * 7) / 5, n - 1, x, y);
        }
    }
}

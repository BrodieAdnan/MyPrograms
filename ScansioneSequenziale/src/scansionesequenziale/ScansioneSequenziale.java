package scansionesequenziale;

import java.util.*;

/**
 * @Param esegue la scansione sequenziale di riordino di un array.
 * @author Adnan Gazi Adnan Latif.
 */
public class ScansioneSequenziale {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("dimmi la dimensione del vettore : ");
        int dim = input.nextInt();
        int[] vettore = new int[dim];
        for (int i = 0; i < dim; i++) {
            vettore[i] = input.nextInt();
        }
        int posmin;
        for (int curs = 0; curs < dim - 1; curs++) {
            posmin = curs;
            for (int i = curs + 1; i < dim; i++) {
                if (vettore[posmin] > vettore[i]) {
                    posmin = i;
                }
            }
            int temp = vettore[posmin];
            vettore[posmin] = vettore[curs];
            vettore[curs] = temp;
        }
        for (int i = 0; i < dim; i++) {
            System.out.print(vettore[i]+" ");
        }
    }
}

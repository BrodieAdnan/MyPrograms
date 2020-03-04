package scrivi;

/**
 * **************************************
 * PENNA
 *
 * @author Gazi Adnan Latif
 * @brief simula l'utilizzo di una penna.
 * @date 11/04/2017
 ****************************************
 */
public class Penna {

    private int ink;

    public Penna(int ink) {
        this.ink = ink;
    }

    public int getInk() {
        return ink;
    }

    public boolean scarico() {
        if (ink >= 0) {
            return false;
        } else {
            return true;
        }
    }

    public String scrivi(String s) {
        int caratteri = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                caratteri++;
            }
        }
        if (caratteri < ink) {
            ink -= caratteri;
            return s;
        } else {
            int temp = ink;
            ink = 0;
            return s.substring(0, temp);
        }
    }
}

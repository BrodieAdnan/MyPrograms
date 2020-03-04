package scrivi.ricarica;

/**
 * ***************************************************
 * STILOGRAFICA
 *
 * @author Gazi Adnan Latif
 * @brief simula l'utilizzo di una penna ricaricabile.
 * @date 11/04/2017
 *****************************************************
 */
public class Stilografica extends Penna{
    
    private int capacita;
    
    public Stilografica(int ink) {
        super(ink);
        capacita=ink;
    }
    
    public boolean piena(){
        if (ink==capacita) {
            return true;
        } else {
            return false;
        }
    }

    public void ricarica(int q){
        if (ink+q<capacita) {
            ink+=q;
        } else {
            ink=capacita;
        }
    }
    public void ricarica(){
        ink=capacita;
    }
}

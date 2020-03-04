package tempo;

/**
 **********************************************
 * CIFRA
 *
 * @author Adnan Gazi Latif
 * @brief Tipo usato dalle cifre dell'orologio.
 * @date 11/04/2017
 **********************************************
 */
class Cifra {

    private Incrementatore incremento;
    private Object cifraPrecedente;

    Cifra(int limite, Object cifraPrecedente) {
        incremento = new Incrementatore(limite);
        this.cifraPrecedente = cifraPrecedente;
    }

    void incrementa() { //richiamo incremento di Incrementatore.
        incremento.incrementa();
        if (incremento.getValore() == 0) {
            if (cifraPrecedente instanceof Cifra) { //se cifraPrecedente è di tipo Cifra.
                ((Cifra) cifraPrecedente).incrementa(); //casting da Object a Cifra.
            } else { //altrimenti è di tipo CifraFinale.
                ((CifraFinale) cifraPrecedente).incrementa(); //casting da Object a CifraFinale.
            }
        }
    }

    int getValore() { //restituisce il valore da Incrementatore.
        return incremento.getValore();
    }
}

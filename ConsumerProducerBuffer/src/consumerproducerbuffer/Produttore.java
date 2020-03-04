package consumerproducerbuffer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Produttore extends Thread {

    private Monitor b;
    private String name;

    Produttore(String pin, Monitor buffer) { //PIN: personal identificator number.
        name = pin;
        b = buffer;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int rand=(int)(Math.random()*1000); //numero casuale da 0 a 99.
            try {
                sleep(rand);
                b.set(rand);
                System.out.println(name + " set  " + rand + "  in the buffer.");
            } catch (InterruptedException ex) {
                Logger.getLogger(Produttore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

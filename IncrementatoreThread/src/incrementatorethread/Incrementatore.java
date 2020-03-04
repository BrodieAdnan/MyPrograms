package incrementatorethread;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Incrementatore extends Thread {

    Buffer numero;
    String name;

    Incrementatore(String name, Buffer numero) {
        this.numero = numero;
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            int rand = (int) (long) (Math.random() * 10);
            try {
                sleep(rand);
                numero.incrementa();
                //numero.incrementazione();
                System.out.println("thread numero " + name + "    sleep di " + rand + "    il numero ora vale " + numero.getNumero());
            } catch (InterruptedException ex) {
                Logger.getLogger(Incrementatore.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}

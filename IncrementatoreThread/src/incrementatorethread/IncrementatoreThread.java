package incrementatorethread;

public class IncrementatoreThread {

    public static void main(String[] args) throws InterruptedException {
        Buffer numero = new Buffer();
        Incrementatore primo = new Incrementatore("1", numero);
        Incrementatore secondo = new Incrementatore("2", numero);
        Incrementatore terzo = new Incrementatore("3", numero);
        Incrementatore quarto = new Incrementatore("4", numero);
        Incrementatore quinto = new Incrementatore("5", numero);
        Incrementatore sesto = new Incrementatore("6", numero);
        Incrementatore settimo = new Incrementatore("7", numero);
        Incrementatore ottavo = new Incrementatore("8", numero);
        Incrementatore nono = new Incrementatore("9", numero);
        Incrementatore decimo = new Incrementatore("10", numero);
        primo.start();
        secondo.start();
        terzo.start();
        quarto.start();
        quinto.start();
        sesto.start();
        settimo.start();
        ottavo.start();
        nono.start();
        decimo.start();
        primo.join();
        secondo.join();
        terzo.join();
        quarto.join();
        quinto.join();
        sesto.join();
        settimo.join();
        ottavo.join();
        nono.join();
        decimo.join();

        System.out.println(numero.getNumero());
    }

}

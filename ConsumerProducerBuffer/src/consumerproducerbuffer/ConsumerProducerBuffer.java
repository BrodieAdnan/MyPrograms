package consumerproducerbuffer;

public class ConsumerProducerBuffer {

    public static void main(String[] args) throws InterruptedException {

        Monitor buffer = new Monitor();

        Produttore primo = new Produttore("producer n.1", buffer);
        Produttore secondo = new Produttore("producer n.2", buffer);
        Produttore terzo = new Produttore("producer n.3", buffer);
        Produttore quarto = new Produttore("producer n.4", buffer);
        Produttore quinto = new Produttore("producer n.5", buffer);
        Produttore sesto = new Produttore("producer n.6", buffer);
        Produttore settimo = new Produttore("producer n.7", buffer);
        Produttore ottavo = new Produttore("producer n.8", buffer);
        Produttore nono = new Produttore("producer n.9", buffer);
        Produttore decimo = new Produttore("producer n.10", buffer);

        Consumatore uno = new Consumatore("consumer n.1", buffer);
        Consumatore due = new Consumatore("consumer n.2", buffer);
        Consumatore tre = new Consumatore("consumer n.3", buffer);
        Consumatore quatro = new Consumatore("consumer n.4", buffer);
        Consumatore cinque = new Consumatore("consumer n.5", buffer);
        Consumatore sei = new Consumatore("consumer n.6", buffer);
        Consumatore sette = new Consumatore("consumer n.7", buffer);
        Consumatore otto = new Consumatore("consumer n.8", buffer);
        Consumatore nove = new Consumatore("consumer n.9", buffer);
        Consumatore dieci = new Consumatore("consumer n.10", buffer);

        //start produttori.
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

        //start consumatori.
        uno.start();
        due.start();
        tre.start();
        quatro.start();
        cinque.start();
        sei.start();
        sette.start();
        otto.start();
        nove.start();
        dieci.start();

        //join produttori.
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
        
        //join consumatori.
        uno.join();
        due.join();
        tre.join();
        quatro.join();
        cinque.join();
        sei.join();
        sette.join();
        otto.join();
        nove.join();
        dieci.join();

        System.out.println((buffer.state())?"Nessun elemento è stato perso, il monitor gestisce gli accessi.":"Qualche elemento è stato perso, il monitor non ha gestito bene gli accessi.");
    }

}

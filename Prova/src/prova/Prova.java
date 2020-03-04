package prova;

public class Prova {

    public static void main(String[] args) throws Exception {
        Lista<Integer> l = new Lista();
        l.addToTail(5);
        l.addToPos(1, 0);
        l.addToHead(10);
        l.addToTail(30);
        l.addToTail(40);
        l.addToPos(45, 560);
        l.remToHead();
        l.remToTail();
        l.remToPos(2);
        boolean bool = (l.search(5));
        for (int i = 0; i < l.lunghezza(); i++) {
            System.out.println((l.estract(i)));
        }
        System.out.println(bool);
    }

}

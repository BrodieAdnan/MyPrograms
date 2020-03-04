package adtset;

public class AdtSet {

    public static void main(String[] args) throws Exception {
//        Lista<Integer> l = new Lista();
//        l.addToTail(5);
//        l.addToPos(1, 0);
//        l.addToHead(10);
//        l.addToTail(30);
//        l.addToTail(40);
//        l.addToPos(45, 560);
//        l.remToHead();
//        l.remToTail();
//        l.remToPos(2);
//        boolean bool = (l.search(5));
//        for (int i = 0; i < l.lunghezza(); i++) {
//            System.out.println((l.estract(i)));
//        }
//        System.out.println(bool);
        Set<Integer> a = new Lista();
        a.add(1);
        a.add(2);
        a.add(3);
        Set<Integer> b = new Lista();
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(3);
        if (!b.isEmpty()) {
            b.clear();
        }
        b.add(1);
        if (b.contains(1)) {
            b.add(2);
        }
        System.out.println(a.toString());
        System.out.println(b.toString());
        a.subtract(b);
        System.out.println(a.toString());
        a.union(b);
        System.out.println(a.toString());
        a.intersect(b);
        System.out.println(a.toString());
    }
}

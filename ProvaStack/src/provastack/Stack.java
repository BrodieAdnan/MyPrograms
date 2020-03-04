package provastack;

public class Stack {

    private Object[] stack;
    private int lunghezza;
    private int testa;

    public Stack(int lunghezza) {
        this.lunghezza = lunghezza;
        stack = new Object[lunghezza];
        testa = -1;
    }

    public void push(Object elem) {
        if (testa + 1 < lunghezza) {
            testa++;
            stack[testa] = elem;
        } else {
            System.out.println("Stack Over Flow !");
        }
    }

    public void pop() {
        if (testa > -1) {
            stack[testa--] = " ";
        } else {
            System.out.println("Index Out Of Bound !");
        }
    }

    public Object top() {
        String s = "";
        if (testa > -1) {
            s += stack[testa];
        } else {
            System.out.println("Index Out Of Bound !");
        }
        return s;
    }

    @Override
    public String toString() {
        String s = "[";
        for (int i = 0; i < lunghezza - 1; i++) {
            if (!stack[i].equals(" ")) {
                s += stack[i] + ", ";
            }
        }
        s += stack[lunghezza - 1] + "]";
        return s;
    }
}

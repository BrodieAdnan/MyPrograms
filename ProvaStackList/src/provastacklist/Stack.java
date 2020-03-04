package provastacklist;

import java.util.*;

public class Stack {
    private ArrayList stack;
    private int testa;
    
    public Stack(){
        stack=new ArrayList();
        testa=-1;
    }
    
    public void push(Object elem){
        stack.add(elem);
        testa++;
    }
    
    public void pop(){
        stack.remove(testa);
        testa--;
    }
    
    public Object top(){
        return stack.get(testa);
    }
    
    @Override
    public String toString() {
        return stack.toString();
    }
}

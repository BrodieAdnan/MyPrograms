package provastacklist;

public class ProvaStackList {

    public static void main(String[] args) {
        Stack stack=new Stack();
        stack.push("1");
        System.out.println(stack.top());
        stack.push("2");
        System.out.println(stack.top());
        stack.push("3");
        System.out.println(stack.top());
        System.out.println(stack.toString());

        stack.pop();
        stack.pop();
        stack.pop();
        System.out.println(stack.toString());
    }
    
}

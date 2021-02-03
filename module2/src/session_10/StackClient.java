package session_10;

public class StackClient {
    public static void main(String[] args) throws Exception {
        Stack stack = new Stack(5);
        stack.push(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println("size of stack " +stack.size());
        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }
        System.out.println("size of stack after " +stack.size());
    }
}

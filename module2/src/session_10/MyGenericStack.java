package session_10;

import java.util.EmptyStackException;
import java.util.LinkedList;

public class MyGenericStack<Object> {
    private LinkedList<Object> stack;

    public MyGenericStack() {
        stack = new LinkedList();
    }

    public void push(Object element) {
        stack.addFirst(element);
    }

    public Object pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.removeFirst();
    }

    public int size() {
        return stack.size();
    }

    public boolean isEmpty() {
        if (stack.size() == 0) {
            return true;
        }
        return false;
    }
}


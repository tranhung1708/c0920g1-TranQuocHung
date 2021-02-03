package session_9;

import java.util.ArrayList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        LinkedList linkedList = new LinkedList(10);
        linkedList.addFirst(11);
        linkedList.addFirst(12);
        linkedList.addFirst(13);

        linkedList.add(4, 9);
        linkedList.add(4, 8);
        linkedList.printList();
    }
}

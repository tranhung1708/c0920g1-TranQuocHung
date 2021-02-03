package session_9.BaiTap;

public class TestLinkedList {
    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.addFirst(3);
        linkedList.addFirst(4);
        linkedList.addFirst(5);
        linkedList.addFirst(6);
        linkedList.addLast(7);
        linkedList.addLast(8);
        linkedList.addLast(9);
        linkedList.addLast(10);
        linkedList.addFirst(15);
        linkedList.removeIndex(3);
        linkedList.displayList();
    }

}

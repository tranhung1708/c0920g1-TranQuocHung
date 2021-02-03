package session_9.BaiTap;


public class LinkedList<E> {
    private Node tail;

    class Node<E> {
        public E element = null;
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return data;
        }
    }

    private Node head;
    private int currentSize;
    private int numNodes;

    public void LinkedList(Object data) {
        head = new Node(data);
        this.currentSize++;
    }

    public void addFirst(E e) {
        Node newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        currentSize++;
        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            tail = tail.next;
        }
        currentSize++;
    }

    public E removeFirst(int i) {
        if (currentSize == 0) return null;
        else {
            Node temp = head;
            head = head.next;
            currentSize--;
            if (head == null) tail = null;
            return (E) temp.element;
        }
    }

    public E removeLast() {
        if (currentSize == 0) return null;
        else if (currentSize == 1) {
            Node temp = head;
            head = tail = null;
            currentSize = 0;
            return (E) temp.element;
        } else {
            Node current = head;
            for (int i = 0; i < currentSize - 2; i++)
                current = current.next;

            Node temp = tail;
            tail = current;
            tail.next = null;
            currentSize--;
            return (E) temp.element;
        }
    }

    public E removeIndex(int index) {
        if (index < 0 || index >= currentSize) return null;
        else if (index == 0) return removeFirst(1);
        else {
            Node previous = head;

            for (int i = 1; i < index; i++) {
                previous = previous.next;
            }
            Node current = previous.next;
            previous.next = current.next;
            currentSize--;
            return (E) current.element;
        }
    }

    public void displayList() {
        Node jump = head;
        while (jump != null) {
            System.out.println(jump.data);
            jump = jump.next;
        }
    }

}

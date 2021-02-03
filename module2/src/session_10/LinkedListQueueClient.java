package session_10;

public class LinkedListQueueClient {
    public static void main(String[] args) {
        MyLinkedListQueue queue  = new MyLinkedListQueue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.dequeue();
        queue.dequeue();
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        System.out.println(queue.dequeue().key);
    }
}

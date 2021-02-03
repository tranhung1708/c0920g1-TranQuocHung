package session_9;

public class MyListTest {
    public static void main(String[] args) {
        MyList<Integer> listInterger = new MyList<Integer>();
        listInterger.add(2);
        listInterger.add(5);
        listInterger.add(6);
        listInterger.add(7);
        listInterger.add(8);
        listInterger.add(9);
        System.out.println(listInterger.get(4));
        System.out.println(listInterger.get(3));
        System.out.println(listInterger.get(2));
    }
}

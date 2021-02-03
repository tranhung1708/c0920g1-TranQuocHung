package session_9.BaiTap;

import java.util.Arrays;
import java.util.LinkedList;

public class TestArrayList {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
        arrayList.add(0,6);
        arrayList.add(1,5);
        arrayList.add(2,4);
        arrayList.add(3,3);
        arrayList.add(4,2);
        arrayList.add(5,1);
        System.out.println(arrayList);
        System.out.println(arrayList.add1(7));
        System.out.println(arrayList);
        System.out.println(arrayList.getE(1));
        for (int i=0; i<arrayList.getSize(); i++) {
            System.out.println(arrayList.get(i));
        }
    }
}

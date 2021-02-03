package session_10.BaiTap;

import java.util.Arrays;
import java.util.Stack;

public class DaoNguocPhanTuTrongMangStack<Object> {


    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();
        Integer[] array = new Integer[5];
        array[0] = 1;
        array[1] = 2;
        array[2] = 3;
        array[3] = 4;
        array[4] = 5;
       for (int i =0 ; i < array.length ;i++){
           stack.push(array[i]);
       }
       for (int j =0 ; j < array.length; j++){
           array[j] = stack.pop();
       }
        System.out.println(stack);
        System.out.println(Arrays.toString(array));
    }
}

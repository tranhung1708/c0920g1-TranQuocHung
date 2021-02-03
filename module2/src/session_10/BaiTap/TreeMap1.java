package session_10.BaiTap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.TreeMap;

public class TreeMap1 {
    public static void main(String[] args) {
        String string = "             Ab          bc       cb      ab     bc ef gh                              ";
        string = string.trim();
        System.out.println("Số lần xuất hiện của các từ : ");
        String[] array = string.split("\\s+");
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        String temp="";
        int count;
        for (String element : array){
                temp =element.toLowerCase();
                if (treeMap.containsKey(temp)){
                    count = treeMap.get(temp);
                    treeMap.put(temp,count+1);
                } else {
                    treeMap.put(temp,1);
                }
        }
        System.out.println(treeMap);
    }
}

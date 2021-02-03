package session_10.BaiTap;

import java.io.*;
import java.util.*;

class TreMap {
    private static final char SPACE = ' ';
    private static final char BREAK_LINE = '\t';
    private static final char TAB = '\n';

    public static Map<String, Integer> countWords(String input) {
        // khởi tạo wordMap
        return getStringIntegerMap(input);
    }

    private static Map<String, Integer> getStringIntegerMap(String input) {
        Map<String, Integer> wordMap = new TreeMap<>();
        return getStringIntegerMap(input, wordMap);
    }

    private static Map<String, Integer> getStringIntegerMap(String input, Map<String, Integer> wordMap) {
        if (input == null) {
            return wordMap;
        }
        int size = input.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            if (input.charAt(i) != SPACE && input.charAt(i) != TAB
                    && input.charAt(i) != BREAK_LINE) {
                // build một từ
                sb.append(input.charAt(i));
            } else {
                // thêm từ vào wordMap
                addWord(wordMap, sb);
                sb = new StringBuilder();
            }
        }
        addWord(wordMap, sb);
        return wordMap;
    }

    public static void addWord(Map<String, Integer> wordMap, StringBuilder sb) {
        StringMethod(wordMap, sb);
    }
    static void StringMethod(Map<String, Integer> wordMap, StringBuilder sb) {
        String word = sb.toString();
        if (word.length() == 0) {
            return;
        }
        if (wordMap.containsKey(word)) {
            int count = wordMap.get(word) + 1;
            wordMap.put(word, count);
        } else {
            wordMap.put(word, 1);
        }
    }

    public static void main(String[] args) {
        String str = "ab bc ac ab ac";
        System.out.println(str);
        System.out.println("Số lần xuất hiện của các từ: ");
        Map<String, Integer> wordMap = countWords(str);
        for (String key : wordMap.keySet()) {
            System.out.print(key + " " + wordMap.get(key) + "\n");
        }
    }
}

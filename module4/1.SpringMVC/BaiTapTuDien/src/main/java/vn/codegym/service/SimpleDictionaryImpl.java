package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Dictionary;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SimpleDictionaryImpl implements DictionaryService {
    private static Map<Integer, Dictionary>dictionary = new HashMap<>();
    static {
        dictionary.put(1,new Dictionary("greeting","chào hỏi"));
        dictionary.put(2,new Dictionary("bicycle","xe đạp"));
        dictionary.put(3,new Dictionary("computer","máy tính"));
        dictionary.put(4,new Dictionary("technology","công nghệ"));
        dictionary.put(5,new Dictionary("information","thông tin"));
        dictionary.put(6,new Dictionary("keyboard","bàn phím"));
        dictionary.put(7,new Dictionary("screen  ","màn hình"));
        dictionary.put(8,new Dictionary("setup","cài đặt"));
        dictionary.put(9,new Dictionary("position","vị trí"));
        dictionary.put(10,new Dictionary("style","phong cách"));
    }
    @Override
    public String search(String searchWord) {
        String result = null;
        List<Dictionary> dictionaries = new ArrayList<>(dictionary.values());
        for (int i=0;i<dictionaries.size();i++){
            if (searchWord.equalsIgnoreCase(dictionaries.get(i).getVI())){
                result = (dictionaries.get(i).getEN());
            }
        }
        return result;
    }
}

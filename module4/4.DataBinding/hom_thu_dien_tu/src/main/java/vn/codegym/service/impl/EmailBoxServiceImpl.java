package vn.codegym.service.impl;

import org.springframework.stereotype.Service;
import vn.codegym.service.EmailBoxService;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmailBoxServiceImpl implements EmailBoxService {
    public static List<String> listLanguages = new ArrayList<>();
    public static List<Integer> page_size=new ArrayList<>();

    static {
        listLanguages.add("English");
        listLanguages.add("Vietnamese");
        listLanguages.add("Japan");
        listLanguages.add("Chinese");
    }

    static {
        page_size.add(5);
        page_size.add(10);
        page_size.add(15);
        page_size.add(25);
        page_size.add(50);
        page_size.add(100);
    }

    @Override
    public List<String> getAllLanguage() {
        return listLanguages;
    }

    @Override
    public List<Integer> getAllPageSize() {
        return page_size;
    }
}

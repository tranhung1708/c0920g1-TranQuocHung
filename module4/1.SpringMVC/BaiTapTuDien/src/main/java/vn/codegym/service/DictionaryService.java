package vn.codegym.service;

import org.springframework.beans.factory.annotation.Autowired;
public interface DictionaryService {
    String search(String searchWord);
}

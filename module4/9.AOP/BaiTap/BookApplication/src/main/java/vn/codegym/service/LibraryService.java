package vn.codegym.service;

import vn.codegym.model.Library;

import java.util.List;

public interface LibraryService {
    List<Library> findAll();
    Library findById(int id);
    void save(Library library);
}

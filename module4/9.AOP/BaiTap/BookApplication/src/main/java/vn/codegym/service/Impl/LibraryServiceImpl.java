package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.codegym.model.Library;
import vn.codegym.repository.LibraryRepository;
import vn.codegym.service.LibraryService;

import java.util.List;
@Service
public class LibraryServiceImpl implements LibraryService {
    @Autowired
    LibraryRepository libraryRepository;
    @Override
    public List<Library> findAll() {
        return libraryRepository.findAll();
    }

    @Override
    public Library findById(int id) {
        return libraryRepository.findById(id).orElse(null);
    }

    @Override
    public void save(Library library) {
        libraryRepository.save(library);
    }
}

package vn.codegym.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import vn.codegym.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> finAll();

    void save(Product product);

    Product finById(int id);

    void update( Product product);

    void remove(int id);
}

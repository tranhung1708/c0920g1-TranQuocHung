package vn.codegym.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import vn.codegym.model.Product;
import vn.codegym.repository.ProductRepository;
import vn.codegym.service.ProductService;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> finAll() {
        return productRepository.findAll();
    }

    @Override
    public void save(Product product) {
        productRepository.save(product);
    }

    @Override
    public Product finById(int id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public void update(Product product) {
    productRepository.save(product);
    }

    @Override
    public void remove(int id) {
    productRepository.deleteById(id);
    }
}

package service;

import model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductServiceImpl implements ProductService {
    private static Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "dien thoai", 1200000, "vip", "china"));
        products.put(2, new Product(2, "may tinh", 1200000, "vip", "china"));
        products.put(3, new Product(3, "den xe oto", 1200000, "vip", "china"));
        products.put(4, new Product(4, "ao quan", 1200000, "vip", "china"));
        products.put(5, new Product(5, "giay dep", 1200000, "vip", "china"));
    }

    @Override
    public List<Product> finAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id,product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}

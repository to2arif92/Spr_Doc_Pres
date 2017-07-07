package pkg.spring.basic.service;

import pkg.spring.basic.model.Product;

import java.util.List;

/**
 * Created by ArIF on 07-Jul-17.
 */
public interface ProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    List<Product> findProducts(String productId);
    List<Product> getAllProducts();
    void removeProduct(String productId);
    void removeAllProducts();
}

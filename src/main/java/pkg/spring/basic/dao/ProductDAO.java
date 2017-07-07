package pkg.spring.basic.dao;

import pkg.spring.basic.model.Product;

import java.util.List;

/**
 * Created by ArIF on 26-Apr-17.
 */
public interface ProductDAO {
    void addProduct(Product product);
    void updateProduct(Product product);
    List<Product> findProducts(String productId);
    List<Product> getAllProducts();
    void removeProduct(String productId);
    void removeAllProducts();
}

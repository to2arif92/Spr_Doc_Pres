package pkg.spring.basic.service;

import pkg.spring.basic.model.Product;

import java.util.List;

/**
 * Created by ArIF on 07-Jul-17.
 */
public interface ProductService {
    void addProduct(Product product);
    void updateProduct(Product product);
    void updateProductByID(String productId, Product product);
    List<Product> findProducts(String productId);
    Product findProductById(String productCode);
    List<Product> findAllProducts();
    void removeProductById(String productId);
    void removeAllProducts();
}

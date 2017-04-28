package pkg.spring.basic.dao;

import pkg.spring.basic.model.Product;

import java.util.List;

/**
 * Created by ArIF on 26-Apr-17.
 */
public interface ProductDAO {
    Product getProduct(String pId);
    Product addProduct(Product product);
    Product updateProduct(Product product);
    void deleteProduct(String pId);
    List<Product> getProductList();
}

package pkg.spring.basic.dao;

import pkg.spring.basic.model.Product;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by ArIF on 03-May-17.
 */
public interface ProductDAOjdbc {
    //void setDataSource(DataSource ds);
    void addProduct(Product product);
    List<Product> findProducts(String pId);
    List<Product> getAllProducts();
    void removeProduct(String pId);
    void removeAllProducts();
}

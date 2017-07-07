package pkg.spring.basic.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pkg.spring.basic.dao.ProductDAO;
import pkg.spring.basic.model.Product;

import java.util.List;


/**
 * Created by ArIF on 26-Apr-17.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {
    @Autowired
    private Logger logger;

    // get the configured SessionFactory bean
    @Autowired
    private SessionFactory sessionFactory;

    // ??
    protected Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void addProduct(Product product) {
        getSession().persist(product);
        logger.info("Product saved successfully");
    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    public List<Product> findProducts(String productId) {

        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        List<Product> productList = getSession().createQuery("from Product").list();
        logger.info("Received all Products");
        return productList;
    }

    @Override
    public void removeProduct(String productId) {

    }

    @Override
    public void removeAllProducts() {

    }
}

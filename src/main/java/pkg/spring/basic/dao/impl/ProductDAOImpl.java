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

    // to get rid of instantiating Session obj in all methods
    private Session getSession(){
        return this.sessionFactory.getCurrentSession();
    }

    @Override
    public void addProduct(Product product) {
        logger.info(" ...saving");
        // insert Product entity into the session
        /*Session session = this.sessionFactory.getCurrentSession();
        session.persist(product);*/
        getSession().persist(product);
    }

    @Override
    public void updateProductByID(String productCode, Product product) {
        logger.info(" ...updating by: "+productCode);
        //getSession().merge(findProductById(productCode));
        Product p = getSession().get(Product.class, productCode);
        getSession().update(product);
        Product product1 = getSession().get(Product.class, productCode);
        logger.info(""+ product1.getProductName()+"f    :"+product.getProductName());
    }

    @Override
    public void updateProduct(Product product) {
        logger.info(" ...updating");
        getSession().saveOrUpdate("Product", product);  // here, 'Product' is class name
    }

    @Override
    public Product findProductById(String productCode) {
        logger.info(" ...searching by: "+productCode);
        //logger.info("is open : "+getSession().isOpen());
        //logger.info("fssssssss"+getSession().getTransaction().isActive());
        //return getSession().load(Product.class, productCode); hibernate5Module must be configured/ used
        return getSession().get(Product.class, productCode);
    }

    @Override
    public List<Product> findProducts(String productId) {

        return null;
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public List<Product> findAllProducts() {
        List<Product> productList = getSession().createQuery("from Product").list();
        logger.info("Received all Products");
        return productList;
    }

    @Override
    public void removeProductById(String productId) {
        logger.info(" ...deleting by: "+productId);
        getSession().remove(findProductById(productId));
    }

    @SuppressWarnings("JpaQlInspection")
    @Override
    public void removeAllProducts() {
        getSession().createQuery("delete from "+Product.class.getSimpleName()).executeUpdate();
        logger.info("Removed all Products !!");
    }
}

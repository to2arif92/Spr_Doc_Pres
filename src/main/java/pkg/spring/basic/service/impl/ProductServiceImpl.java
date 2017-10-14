package pkg.spring.basic.service.impl;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.dao.ProductDAO;
import pkg.spring.basic.model.Product;
import pkg.spring.basic.service.ProductService;

import java.util.List;


/**
 * Created by ArIF on 07-Jul-17.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private Logger logger;

    @Autowired
    ProductDAO productDAO;

    @Override
    @Transactional
    public void addProduct(Product product) {
        logger.info("Adding in process");
        productDAO.addProduct(product);
    }

    @Override
    @Transactional
    public Product findProductById(String productCode) {
        logger.info("Find in process");
        return productDAO.findProductById(productCode);
    }

    @Override
    //@Transactionala
    public List<Product> findProducts(String productId) {
        return null;
    }

    @Override
    @Transactional
    public List<Product> findAllProducts() {
        logger.info("Getting all Products");
        return this.productDAO.findAllProducts();
    }

    @Override
    //@Transactional
    /*  NOTE: seemed un-necessary, inefficient thus un-implemented */
    public void updateProductByID(String productId, Product product) {
        logger.info("Target Update in process");
        productDAO.updateProductByID(productId, product);
        //Product product = productDAO.findProductById(productId);
        //productDAO.updateProduct(product);
    }

    @Override
    @Transactional
    public void updateProduct(Product product) {
        logger.info("Update in process");
        productDAO.updateProduct(product);
    }

    @Override
    @Transactional
    public void removeProductById(String productId) {
        logger.info("Deleting in process");
        productDAO.removeProductById(productId);
        logger.info("Product Removed !");
    }

    @Override
    @Transactional
    public void removeAllProducts() {
        productDAO.removeAllProducts();
    }
}

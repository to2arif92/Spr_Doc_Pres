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
    public void addProduct(Product product) {

    }

    @Override
    public void updateProduct(Product product) {

    }

    @Override
    //@Transactional
    public List<Product> findProducts(String productId) {
        return null;
    }

    @Override
    @Transactional
    public List<Product> getAllProducts() {
        logger.info("Getting all Products");
        return this.productDAO.getAllProducts();
    }

    @Override
    public void removeProduct(String productId) {

    }

    @Override
    public void removeAllProducts() {

    }
}

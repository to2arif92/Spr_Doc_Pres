package pkg.spring.basic.dao.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.dao.ProductDAOjdbc;
import pkg.spring.basic.mapper.ProductRowMapper;
import pkg.spring.basic.model.Product;

import java.util.List;

/**
 * Created by ArIF on 03-May-17.
 */
@Service
@Transactional
public class ProductDAOjdbcImpl implements ProductDAOjdbc {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired  // wire it with jdbcTemplate bean with datasource
    private JdbcTemplate jdbcTemplate;

    String[] columnsToShowArray = {
            "product_code",
            "product_name",
            "product_line",
            "product_scale",
            "product_vendor",
            "product_description",
            "quantity_in_stock",
            "buy_price",
            "MSRP"};
    String columnsToShow = String.join(",", columnsToShowArray);

    @Override
    public void addProduct(Product product) {
        String sql = "INSERT INTO products (" +
                "product_code,  " +
                "product_name,  " +
                "product_line,  " +
                "product_scale,  " +
                "product_vendor,  " +
                "product_description,  " +
                "quantity_in_stock,  " +
                "buy_price,  " +
                "MSRP ) VALUES " +
                "(?, ?, ?, ?, ?, ?, ?, ?, ?)";
/*        String sql = "INSERT INTO products (" +
                columnsToShow +
                ") VALUES" +
                " (?, ?, ?, ?, ?, ?, ?, ?, ?)";*/
        Object [] params = new Object[] {
                product.getProductCode(),
                product.getProductName(),
                product.getProductLine(),
                product.getProductScale(),
                product.getProductVendor(),
                product.getProductDescription(),
                product.getQuantityInStock(),
                product.getBuyPrice(),
                product.getMSRP()
        };
        //JdbcTemplate insert = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, params);
        System.out.println("added new row !!!");
        logger.info("Added new row");
    }

    @Override
    public void updateProduct(Product product) {
        String sql = "";
        Object[] params = new Object[]{};
    }

    @Override
    public List<Product> findProducts(String productId) {

        String sql = "SELECT " +
                columnsToShow +
                " FROM products" +
                " WHERE product_code = ?";
        Object [] params = new Object[]{productId};
        logger.info("searching for specific Products");
        List<Product> productList = jdbcTemplate.query(sql, params, new ProductRowMapper());
        return productList;
    }

    @Override
    public List<Product> getAllProducts() {
        String sql = "SELECT " +
                columnsToShow +
                " FROM products ";
        List<Product> productList = jdbcTemplate.query(sql, new ProductRowMapper());
        logger.info("Sending all Products data");
        return productList;
    }

    @Override
    public void removeProduct(String productId) {
        String sql = "DELETE" +
                " FROM products" +
                " WHERE product_code = ?";
        Object [] params = new Object[]{productId};
        logger.info("removed Product = "+productId);
        jdbcTemplate.update(sql, params);
    }

    @Override
    public void removeAllProducts() {
        String sql = "DELETE" +
                " FROM products";
        logger.info("removed all Products entry");
        jdbcTemplate.update(sql, new ProductRowMapper());
    }
}

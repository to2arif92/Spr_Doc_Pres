package pkg.spring.basic.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pkg.spring.basic.dao.ProductDAOjdbc;
import pkg.spring.basic.mapper.ProductRowMapper;
import pkg.spring.basic.model.Product;

import javax.sql.DataSource;
import java.util.List;

/**
 * Created by ArIF on 03-May-17.
 */
@Service
@Transactional
public class ProductDAOjdbcImpl implements ProductDAOjdbc {

    private DataSource dataSource;
    //@SuppressWarnings("SpringJavaAutowiringInspection")
    @Autowired  // wire it with jdbcTemplate bean with datasource
    private JdbcTemplate jdbcTemplate;


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
    }

    @Override
    public List<Product> findProducts(String pId) {
        //List<Product> productList = get
        return null;
    }

    @Override
    public List<Product> getAllProducts() {
        return null;
    }

    @Override
    public void removeProduct(String pId) {

    }

    @Override
    public void removeAllProducts() {

    }
}

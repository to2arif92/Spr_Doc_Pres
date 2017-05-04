package pkg.spring.basic.mapper;

import org.springframework.jdbc.core.RowMapper;
import pkg.spring.basic.model.Product;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by ArIF on 03-May-17.
 */
public class ProductRowMapper implements RowMapper<Product> {
    @Override
    public Product mapRow(ResultSet resultSet, int i) throws SQLException {
        String productCode = resultSet.getString(1);
        String productName = resultSet.getString(2);
        String productLine = resultSet.getString(3);
        String productScale = resultSet.getString(4);
        String productVendor = resultSet.getString(5);
        String productDescription = resultSet.getString(6);
        int quantityInStock = resultSet.getInt(7);
        double buyPrice = resultSet.getDouble(8);
        double MSRP = resultSet.getDouble(9);

        return new Product(productCode, productName, productLine, productScale, productVendor, productDescription, quantityInStock, buyPrice, MSRP);
    }
}

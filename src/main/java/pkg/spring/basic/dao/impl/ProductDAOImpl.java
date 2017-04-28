package pkg.spring.basic.dao.impl;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pkg.spring.basic.dao.ProductDAO;
import pkg.spring.basic.model.Product;

import java.util.*;

/**
 * Created by ArIF on 26-Apr-17.
 */
@Repository
public class ProductDAOImpl implements ProductDAO {

    private static final Map<String, Product> empMap = new HashMap<String, Product>();

    static {
        initEmps();
    }

    private static void initEmps() {
        Product emp1 = new Product("E01", "Smith", "Clerk", "ds", "ads", "wq",12, 12, 2.1);
        Product emp2 = new Product("E02", "Allen", "Salesman", "ds", "ads", "wq",12, 12, 2.1);
        Product emp3 = new Product("E03", "Jones", "Manager", "ds", "ads", "wq",12, 12, 2.1);

        empMap.put(emp1.getProductCode(), emp1);
        empMap.put(emp2.getProductCode(), emp2);
        empMap.put(emp3.getProductCode(), emp3);
    }

    @Override
    public Product getProduct(String pId) {
        return empMap.get(pId);
    }

    @Override
    public Product addProduct(Product product) {
        empMap.put(product.getProductCode(), product);
        return product;
    }

    @Override
    public Product updateProduct(Product product) {
        empMap.put(product.getProductCode(), product);
        return null;
    }

    @Override
    public void deleteProduct(String pId) {
        empMap.remove(pId);
    }

    @Override
    public List<Product> getProductList() {
        Collection<Product> c = empMap.values();
        List<Product> list = new ArrayList<Product>();
        list.addAll(c);
        return list;
    }
}

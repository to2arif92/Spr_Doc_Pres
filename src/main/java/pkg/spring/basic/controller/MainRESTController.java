package pkg.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pkg.spring.basic.dao.ProductDAO;
import pkg.spring.basic.dao.ProductDAOjdbc;
import pkg.spring.basic.model.Product;

import java.util.List;

/**
 * Created by ArIF on 26-Apr-17.
 */
@RestController
public class MainRESTController {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    ProductDAOjdbc productDAOjdbc;
    @RequestMapping("/dd")
    public String welcome() {
        productDAOjdbc.addProduct(new Product("E01", "Smith", "Clerk", "ds", "ads", "wq",12, 12, 2.1));
        return "Welcome to RestTemplate Example.";
    }

    @RequestMapping(value = "/employees", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getEmployees() {
        List<Product> list = productDAO.getProductList();
        return list;
    }

    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public Product getEmployee(@PathVariable("empNo") String empNo) {
        return productDAO.getProduct(empNo);
    }

    @RequestMapping(value = "/employees", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public Product addEmployee(Product emp) {
        return productDAO.addProduct(emp);
    }

    @RequestMapping(value = "/employees", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public Product updateEmployee(Product emp) {
        return productDAO.updateProduct(emp);
    }

    @RequestMapping(value = "/employees/{empNo}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteEmployee(@PathVariable("empNo") String empNo) {
        productDAO.deleteProduct(empNo);
    }

}

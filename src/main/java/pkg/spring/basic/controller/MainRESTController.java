package pkg.spring.basic.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import pkg.spring.basic.dao.ProductDAO;
import pkg.spring.basic.dao.ProductDAOjdbc;
import pkg.spring.basic.model.Product;
import pkg.spring.basic.service.ProductService;

import java.util.List;

/**
 * Created by ArIF on 26-Apr-17.
 */
@RestController
public class MainRESTController {

    @Autowired
    ProductDAOjdbc productDAOjdbc;

    @Autowired
    ProductService productService;

    /*@Autowired(required=true)
    @Qualifier(value="productService")
    public void setPersonService(ProductService ps){
        this.ProductService = ps;
    }*/

    /*  Test Rest   */
    @RequestMapping("/dd")
    public String welcome() {
        //productDAOjdbc.addProduct(new Product("E01", "Smith", "Clerk", "ds", "ads", "wq",12, 12, 2.1));
        return "Welcome to RestTemplate Example.";
    }
    /*  Get All Products    */
    @RequestMapping(value = "/products", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getProducts() {
        return productService.getAllProducts();
    }


    /*  Get a targeted product  */
    @RequestMapping(value = "/products/{productId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public List<Product> getProduct(@PathVariable("productId") String productId) {
        return productDAOjdbc.findProducts(productId);
    }


    @RequestMapping(value = "/products", //
            method = RequestMethod.POST, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public void addProduct(Product product) {
        productDAOjdbc.addProduct(product);
    }

    @RequestMapping(value = "/products", //
            method = RequestMethod.PUT, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void updateProduct(Product emp) {
        productDAOjdbc.updateProduct(emp);
    }

    @RequestMapping(value = "/products/{productId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteProduct(@PathVariable("productId") String productId) {
        productDAOjdbc.removeProduct(productId);
    }

}

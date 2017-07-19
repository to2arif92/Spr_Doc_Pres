package pkg.spring.basic.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import pkg.spring.basic.dao.ProductDAOjdbc;
import pkg.spring.basic.model.Product;
import pkg.spring.basic.service.ProductService;

import javax.annotation.PreDestroy;
import java.util.List;

/**
 * Created by ArIF on 26-Apr-17.
 */
@RestController
//@RequestMapping("/products")
public class MainRESTController {

    @Autowired
    Logger logger;

    // Raw JDBC with Spring template
    @Autowired
    ProductDAOjdbc productDAOjdbc;

    // Spring managed Transaction + Hibernate
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
    /*-----  C   */
    /*  Create a new Product    */
    @RequestMapping(value = "/products", //
            method = RequestMethod.POST, //
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public void addProduct(@RequestBody Product product/*, HttpServletRequest request, HttpServletResponse response*/) {
        if (product != null){
            logger.info("REST - Create: "+ product);
            productService.addProduct(product);
            logger.info("Product saved successfully");
            //productDAOjdbc.addProduct(product);
        } else {
            logger.info("REST - Nothing to Create !!");
        }

        /*response.setHeader("1", "uno");

        //http://localhost:8080/spring-utility/person/1
        response.setHeader("Location", request.getRequestURL().append(product.getProductCode()).toString());*/
    }

    /*-----  R   */
    /*  Read a specific Product */
    @RequestMapping(value = "/products/{productId}", //
            method = RequestMethod.GET,/*
            consumes = MediaType.APPLICATION_JSON_VALUE,*/
            produces = { MediaType.APPLICATION_JSON_VALUE/*, MediaType.APPLICATION_XML_VALUE*/ })
    public Product findProductByID(@PathVariable String productId/*,
                                                @RequestBody Product product*/) {
        logger.info("REST - Read: "+"/n by: "+productId);
        return productService.findProductById(productId);
        //logger.info("Product updated successfully");
    }

    /*  Read All Products    */
    //@JsonView
    @RequestMapping(value = "/products", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public List<Product> getAllProducts() {
        return productService.findAllProducts();
    }


    /*  -> Read a targeted product  */
    /*@RequestMapping(value = "/products/{productId}", //
            method = RequestMethod.GET, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })

    public List<Product> getProduct(@PathVariable("productId") String productId) {
        return productDAOjdbc.findProducts(productId);
    }*/

    /*-----  U   */
    /*  Update a product without specifying 'by which?'    */
    @PutMapping(value = "/products", //
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void updateProduct(@RequestBody Product product) {
        //productDAOjdbc.updateProduct(product);
        logger.info("REST - Update: "+ product);
        productService.updateProduct(product);
        logger.info("Product updated successfully");
    }

    /*  Update a specific product by Id (which is for sure faster?) */
    /*  NOTE: seemed un-necessary, inefficient thus un-implemented */
    @PutMapping(value = "/products/{productId}", //
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void updateProductByID(@PathVariable String productId,
                                            @RequestBody Product product) {
        logger.info("REST - Update: "+ product+" by: "+productId);
        productService.updateProductByID(productId, product);
        logger.info("Product updated successfully");
    }

    /*  Update multiple products    */



    /*-----  D   */
    /*  Delete a product    */
    @RequestMapping(value = "/products/{productId}", //
            method = RequestMethod.DELETE, //
            produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
    public void deleteProductById(@PathVariable("productId") String productId) {
        //productDAOjdbc.removeProduct(productId);
        productService.removeProductById(productId);
    }


    /*  Delete all products    */
    @RequestMapping(value = "/products", //
            method = RequestMethod.DELETE)
    public void deleteAllProducts() {
        productService.removeAllProducts();
    }

    @PreDestroy
    void test(){
        logger.info("destroyed");
    }

}

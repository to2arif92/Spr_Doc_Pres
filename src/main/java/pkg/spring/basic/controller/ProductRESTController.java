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
/*@RequestMapping(
        value = "/products",    // suffix/root URI
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = {MediaType.APPLICATION_JSON_VALUE*//*,
                MediaType.APPLICATION_XML_VALUE*//*}
)*/
// @RequestBody and @ResponseBody/@RestController does 'consumes', 'produces' automatically
public class ProductRESTController {

    @Autowired
    Logger logger;

    // Raw JDBC with Spring template
    /*@Autowired
    ProductDAOjdbc productDAOjdbc;*/

    // Spring managed Transaction + Hibernate
    @Autowired
    ProductService productService;


    /*  Test Rest   */
    @RequestMapping("/dd")
    public String welcome() {
        //productDAOjdbc.addProduct(new Product("E01", "Smith", "Clerk", "ds", "ads", "wq",12, 12, 2.1));
        return "Welcome to RestTemplate Example.";
    }



    /*-----  C   -----*/
    /*  Create a new Product    */
    @PostMapping("/products")   // equals to "/products/" if was not defined at class lvl
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



    /*-----  R   -----*/
    /*  Read a specific Product */
    @GetMapping("/products/{productId}")
    public Product findProductByID(@PathVariable String productId/*,
                                                @RequestBody Product product*/) {
        logger.info("REST - Read: "+"/n by: "+productId);
        return productService.findProductById(productId);
        //return productDAOjdbc.findProducts(productId);
    }

    /*  Read All Products    */
    //@JsonView
    @GetMapping("/products")
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }



    /*-----  U   -----*/
    /*  Update a product without specifying 'by which?'    */
    @PutMapping("/products")
    public void updateProduct(@RequestBody Product product) {
        //productDAOjdbc.updateProduct(product);
        logger.info("REST - Update: "+ product);
        productService.updateProduct(product);
        logger.info("Product updated successfully");
    }

    /*  Update a specific product by Id (which is for sure faster?) */
    /*  NOTE: seemed un-necessary, inefficient thus un-implemented */
    @PutMapping("/products/{productId}")
    public void updateProductByID(@PathVariable String productId,
                                            @RequestBody Product product) {
        logger.info("REST - Update: "+ product+" by: "+productId);
        productService.updateProductByID(productId, product);
        logger.info("Product updated successfully");
    }

    /*  Update multiple products    */



    /*-----  D   -----*/
    /*  Delete a product    */
    @DeleteMapping("/products/{productId}")
    public void deleteProductById(@PathVariable("productId") String productId) {
        //productDAOjdbc.removeProduct(productId);
        productService.removeProductById(productId);
    }

    /*  Delete all products    */
    @DeleteMapping("/products/")
    public void deleteAllProducts() {
        productService.removeAllProducts();
    }

    @PreDestroy
    void test(){
        logger.info("destroyed");
    }

}

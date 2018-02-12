package pkg.spring.basic.controller;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pkg.spring.basic.model.Product;
import pkg.spring.basic.service.ProductService;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
        return "Welcome to RestTemplate Example.";
    }



    /*-----  C   -----*/
    /*  Create a new Product    */
    @PostMapping("/products")   // equals to "/products/" if was not defined at class lvl
    @ResponseStatus(HttpStatus.CREATED)
    public void addProduct(@RequestBody Product product) {
        logger.info("REST - Create: "+ product);
        productService.addProduct(product);
        logger.info("Product saved successfully");
        //productDAOjdbc.addProduct(product);

        /*response.setHeader("1", "uno");
        //http://localhost:8080/spring-utility/person/1
        response.setHeader("Location", request.getRequestURL().append(product.getProductCode()).toString());*/
    }



    /*-----  R   -----*/
    /*  Read a specific Product */
    @GetMapping("/products/{productId}")
    @ResponseStatus(HttpStatus.FOUND)
    public Product findProductByID(@PathVariable String productId/*,
                                                @RequestBody Product product*/) {
        logger.info("REST - Read: "+"/n by: "+productId);
        return productService.findProductById(productId);
        //return productDAOjdbc.findProducts(productId);
    }

    /*  Read All Products    */
    //@JsonView
    /*@GetMapping("/products")
    @ResponseStatus(HttpStatus.FOUND)
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }*/
    @GetMapping("/products")
    public ResponseEntity<List<Product>> findAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_JSON)
                .cacheControl(CacheControl.noStore().sMaxAge(24, TimeUnit.HOURS))
                .header("myHeader-1", "myValue-1")
                .header("myHeader-2", "myValue-2")
                .header("Access-Control-Max-Age","86400")
                .body(productService.findAllProducts());
    }


    /*-----  U   -----*/
    /*  Update a product without specifying 'by which?'    */
    @PutMapping("/products")
    @ResponseStatus(HttpStatus.ACCEPTED)
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
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteProductById(@PathVariable("productId") String productId) {
        //productDAOjdbc.removeProduct(productId);
        productService.removeProductById(productId);
    }

    /*  Delete all products    */
    @DeleteMapping("/products/")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteAllProducts() {
        productService.removeAllProducts();
    }

    @PreDestroy
    void test(){
        logger.info("destroyed");
    }

}

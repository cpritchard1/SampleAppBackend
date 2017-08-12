package com.myapp.MyAppBackend.Product;

import com.myapp.MyAppBackend.infrastructure.web.response.*;
//import org.apache.tomcat.util.ExceptionUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by cpritcha on 6/6/17.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping( path = "/{productCode}/findProduct", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<PProduct> performProductLookup(
            @PathVariable(required = true, value = "productCode" ) String productCode) {

        try{
            return new SuccessWebResponse<>(productService.performProductLookup(productCode));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping( path = "/{productCode}/{productName}/{productPrice}/createProduct", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performCreateProduct(
            @PathVariable(required = true, value = "productCode") String productCode,
            @PathVariable(required = true, value = "productName") String productName,
            @PathVariable(required = true, value = "productPrice") float productPrice ) {

        try {
            return new SuccessWebResponse<>(productService.performCreateProduct(productCode, productName, productPrice));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(ExceptionUtils.getRootCauseMessage(e));
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping( path = "/{productId}/{productCode}/{productName}/{productPrice}/updateProduct", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performUpdateProduct(
            @PathVariable(required = true, value = "productId") Integer productId,
            @PathVariable(required = true, value = "productCode") String productCode,
            @PathVariable(required = true, value = "productName") String productName,
            @PathVariable(required = true, value = "productPrice") float productPrice ) {

        try {
            return new SuccessWebResponse<>(productService.performUpdateProduct(productId, productCode, productName, productPrice));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping( path = "/{productId}/deleteProduct", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performDeleteProduct(
            @PathVariable(required = true, value = "productId") Integer productId) {

        try {
            return new SuccessWebResponse<>(productService.performDeleteProduct(productId));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(ExceptionUtils.getRootCauseMessage(e));
            return new FailureWebResponse<>(null, responseMessage);
        }
    }


    @RequestMapping( path = "/allProducts", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<List<PProduct>> performGetAllProducts() {

        try{
            return new SuccessWebResponse<>(productService.performGetAllProducts());
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }
}

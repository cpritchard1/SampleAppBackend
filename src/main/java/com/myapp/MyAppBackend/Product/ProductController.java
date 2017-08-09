package com.myapp.MyAppBackend.Product;

import com.myapp.MyAppBackend.infrastructure.web.response.*;
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
    @ResponseBody public CommonWebResponse<PProduct> performProductLookup(@PathVariable(required = true, value = "productCode" ) String productCode) {

        try{
            return new SuccessWebResponse<>(productService.performProductLookup(productCode));
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @CrossOrigin
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

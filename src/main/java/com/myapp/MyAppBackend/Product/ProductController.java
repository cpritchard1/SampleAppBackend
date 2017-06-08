package com.myapp.MyAppBackend.Product;

import com.myapp.MyAppBackend.infrastructure.web.response.CommonWebResponse;
import com.myapp.MyAppBackend.infrastructure.web.response.FailureWebResponse;
import com.myapp.MyAppBackend.infrastructure.web.response.SuccessWebResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

import org.codehaus.jackson.map.ObjectMapper;

/**
 * Created by cpritcha on 6/6/17.
 */

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @RequestMapping( path = "/{productCode}/findProduct", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<String> performProductLookup(@PathVariable(required = true, value = "productCode" ) String productCode) {

        PProduct product = productService.performProductLookup(productCode);

        if ( product != null ) {
            return new SuccessWebResponse<>("Successfully found product: " + product.getProductName() );
        }
        else {
            return new FailureWebResponse<>("Product " + productCode + " does not exist" );
        }
    }

    @CrossOrigin
    @RequestMapping( path = "/allProducts", method = RequestMethod.GET )
    @ResponseBody public CommonWebResponse<String> performGetAllProducts() {

        List<PProduct> productsList = productService.performGetAllProducts();
        String jsonList = null;

        if ( productsList != null ) {

            try {
                ObjectMapper mapper = new ObjectMapper();
                jsonList = mapper.writeValueAsString(productsList);
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
        else {
            return new FailureWebResponse<>("Failed to get all products");
        }
        return new SuccessWebResponse<>(jsonList);
    }
}

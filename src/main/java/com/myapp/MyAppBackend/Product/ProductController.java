package com.myapp.MyAppBackend.Product;

//import org.apache.tomcat.util.ExceptionUtils;
import com.myapp.MyAppBackend.infrastructure.web.response.*;
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

    // .../product/findProducts?code= &name= &price=
    @RequestMapping( path = "/findProducts", method = RequestMethod.GET  )
    @ResponseBody public CommonWebResponse<List<PProduct>> performProductLookup(
            @RequestParam(required = false, value = "code") String productCode,
            @RequestParam(required = false, value = "name") String productName,
            @RequestParam(required = false, value = "price") Double productPrice) {

        try{
            List<PProduct> products = productService.performProductLookup(productCode, productName, productPrice);

            if(products.isEmpty()){
                ResponseMessage responseMessage = new ErrorResponseMessage("No Products Were Found Matching Search Criteria");
                return new FailureWebResponse<>(null, responseMessage);
            }
            else {
                return new SuccessWebResponse<>(products);
            }
        }
        catch(Exception e){
            System.out.println("********************************");
            System.out.println("Unknown Exception occurred, thrown from ProductController/findProducts");
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(ExceptionUtils.getRootCauseMessage(e));
            return new FailureWebResponse<>(null, responseMessage);
        }
    }

    @RequestMapping( path = "/updateProduct", method = RequestMethod.PUT )
    @ResponseBody public CommonWebResponse<Boolean> performUpdateProduct(
            @RequestBody List<Product> productList ) {

        try {
            ResponseMessage responseMessage = new InfoResponseMessage("Product Successfully Updated");
            return new SuccessWebResponse<>(productService.performUpdateProduct(productList), responseMessage);
        }
        catch(Exception e){
            System.out.println("********************************");
            System.out.println("Unknown Exception occurred, thrown from ProductController/updateProduct");
            System.out.println(e.getMessage());
            ResponseMessage responseMessage = new ErrorResponseMessage(e.getMessage());
            return new FailureWebResponse<>(null, responseMessage);
        }
    }
}

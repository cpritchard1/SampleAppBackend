package com.myapp.MyAppBackend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpritcha on 6/6/17.
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

    public PProduct performProductLookup(String productCode) {

        return productRepo.findProductByCode(productCode);
    }


    public String performCreateProduct(String productCode, String productName, float productPrice) {

        PProduct product = new PProduct(productCode, productName, productPrice);
        productRepo.save(product);
        return "Product successfully created";
    }


    public String performUpdateProduct(Integer productId, String productCode, String productName, float productPrice) {

        PProduct product = productRepo.findProductById(productId);
        product.setProductCode(productCode);
        product.setProductName(productName);
        product.setProductPrice(productPrice);
        productRepo.save(product);
        return "Product successfully updated";
    }


    public String performDeleteProduct(Integer productId) {

        PProduct product = productRepo.findProductById(productId);
        productRepo.delete(product);
        return "Product successfully deleted";
    }


    public List<PProduct> performGetAllProducts() {

        return productRepo.findAll();
    }
}

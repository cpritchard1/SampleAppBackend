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
        PProduct product = null;
        try {
            product = productRepo.findProductBy(productCode);
        }
        catch (Exception e) {
            String msg = String.format(e.getMessage());
        }
        return product;

    }

    public List<PProduct> performGetAllProducts() {

        List<PProduct> productsList = new ArrayList<>();
        try {
            productsList = productRepo.findAll();
        }
        catch (Exception e) {
            String msg = String.format(e.getMessage());
        }
        return productsList;
    }
}

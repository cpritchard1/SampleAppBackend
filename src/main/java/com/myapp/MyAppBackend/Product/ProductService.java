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

        return productRepo.findProductBy(productCode);
    }

    public List<PProduct> performGetAllProducts() {

        return productRepo.findAll();
    }
}

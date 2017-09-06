package com.myapp.MyAppBackend.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import org.springframework.data.domain.Example;

/**
 * Created by cpritcha on 6/6/17.
 */

@Service
public class ProductService {

    @Autowired
    private ProductRepo productRepo;

/* ***********************************************************************************
        Search for all Products matching the created example
 *************************************************************************************/
    public List<PProduct> performProductLookup(String productCode, String productName, Double productPrice) {

        Example<PProduct> example = Example.of(new PProduct(productCode, productName, productPrice));

        List<PProduct> products = productRepo.findAll(example);

        return products;
    }


/* ***********************************************************************************
        Create Update or Delete a Product object and return true on success
 *************************************************************************************/
    public Boolean performUpdateProduct(List<Product> product) {

        product.forEach((row) -> {
            if(row.getSetForDelete()) {
                productRepo.delete(productRepo.findProductById(row.getProductId()));
            }
            else if(row.isNew()) {
                PProduct entity = new ProductToPProductConverter(row).toEntityObject();
                productRepo.save(entity);
            }
            else {
                PProduct entity = productRepo.findProductById(row.getProductId()).updateEntity(row);
                productRepo.save(entity);
            }
        });

        return true;
    }

/* ***********************************************************************************
       Used for setting repository during unit testing
 *************************************************************************************/
    public void setProductRepo(ProductRepo productRepo) {
        this.productRepo = productRepo;
    }
}

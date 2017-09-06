package com.myapp.MyAppBackend.Product;

import com.myapp.MyAppBackend.infrastructure.converter.DomainToEntityConverter;

/**
 * Created by cpritcha on 9/5/17.
 */

public class ProductToPProductConverter extends DomainToEntityConverter<Product, PProduct> {

    ProductToPProductConverter(Product domain) { super(domain); }

    @Override
    public PProduct convertSingleDomainObject(Product domain) {
        return new PProduct(
                domain.getProductCode(),
                domain.getProductName(),
                domain.getProductPrice()
        );
    }
}

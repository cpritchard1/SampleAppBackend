package com.myapp.MyAppBackend.Product;

import com.myapp.MyAppBackend.infrastructure.converter.EntityToDomainConverter;

/**
 * Created by cpritcha on 9/5/17.
 */

public class PProductToProductConverter extends EntityToDomainConverter<PProduct, Product> {

    PProductToProductConverter(PProduct entity) { super(entity); }

    @Override
    public Product convertSingleEntityObject(PProduct entity) {
        return new Product(
                entity.getProductId(),
                entity.getProductCode(),
                entity.getProductName(),
                entity.getProductPrice()
        );
    }
}

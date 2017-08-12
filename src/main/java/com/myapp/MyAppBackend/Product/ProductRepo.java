package com.myapp.MyAppBackend.Product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by cpritcha on 6/6/17.
 */

@Repository
public interface ProductRepo extends JpaRepository<PProduct, String> {

    @Query( value = "SELECT p FROM PProduct p WHERE p.productCode = :productCode" )
    PProduct findProductByCode(@Param("productCode") String productCode);

    @Query( value = "SELECT p FROM PProduct p WHERE p.productId = :productId")
    PProduct findProductById(@Param("productId") Integer productId);
}

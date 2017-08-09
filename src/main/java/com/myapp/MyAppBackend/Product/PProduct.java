package com.myapp.MyAppBackend.Product;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by cpritcha on 6/6/17.
 */

@SuppressWarnings("serial")
@Entity
@Table(name = "PRODUCT", schema = "DEV01")
@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class PProduct implements Serializable {

    @Id
    @Column(name = "CODE")
    private String productPk;

    @Column(name = "NAME")
    private String productName;

    @Column(name = "PRICE")
    private float productPrice;

    public PProduct() {
        // Empty constructor for Hibernate
    }

    // CONSTRUCTOR FOR CREATING NEW PRODUCT
    public PProduct( String code, String name, float price) {

        this.productPk = code;
        this.productName = name;
        this.productPrice = price;
    }

    // GETTER FUNCTIONS FOR PRODUCT ATTRIBUTES
    public String getProductPk() {
        return productPk;
    }

    public String getProductName() {
        return productName;
    }

    public float getProductPrice() {
        return productPrice;
    }
}

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
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PRODUCT_ID", unique = true)
    private Integer productId;

    @Column(name = "PRODUCT_CODE", unique = true)
    private String productCode;

    @Column(name = "PRODUCT_NAME")
    private String productName;

    @Column(name = "PRODUCT_PRICE")
    private float productPrice;

    public PProduct() {
        // Empty constructor for Hibernate
    }

    // CONSTRUCTOR FOR CREATING NEW PRODUCT
    public PProduct( String code, String name, float price) {

        this.productCode = code;
        this.productName = name;
        this.productPrice = price;
    }

    // GETTER FUNCTIONS FOR PRODUCT ATTRIBUTES
    public Integer getProductId() { return productId; }
    public String getProductCode() {
        return productCode;
    }
    public String getProductName() {
        return productName;
    }
    public float getProductPrice() {
        return productPrice;
    }

    // SETTER FUNCTIONS FOR PRODUCT ATTRIBUTES
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setProductPrice(float productPrice) { this.productPrice = productPrice; }
}

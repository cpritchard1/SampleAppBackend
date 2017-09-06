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
    private Double productPrice;

    public PProduct() {
        // Empty constructor for Hibernate
    }

    // CONSTRUCTOR FOR CREATING NEW PRODUCT
    public PProduct( String code, String name, Double price) {

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
    public Double getProductPrice() {
        return productPrice;
    }

    // SETTER FUNCTIONS FOR PRODUCT ATTRIBUTES
    public void setProductId(Integer productId) { this.productId = productId; }
    public void setProductCode(String productCode) { this.productCode = productCode; }
    public void setProductName(String productName) { this.productName = productName; }
    public void setProductPrice(Double productPrice) { this.productPrice = productPrice; }

    public PProduct updateEntity(Product domainObj) {
        this.setProductCode(domainObj.getProductCode());
        this.setProductName(domainObj.getProductName());
        this.setProductPrice(domainObj.getProductPrice());
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PProduct pProduct = (PProduct) o;

        if (Double.compare(pProduct.productPrice, productPrice) != 0) return false;
        if (!productId.equals(pProduct.productId)) return false;
        if (!productCode.equals(pProduct.productCode)) return false;
        return productName.equals(pProduct.productName);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = productId.hashCode();
        result = 31 * result + productCode.hashCode();
        result = 31 * result + productName.hashCode();
        temp = Double.doubleToLongBits(productPrice);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "PProduct{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                '}';
    }
}


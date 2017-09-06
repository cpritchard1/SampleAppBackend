package com.myapp.MyAppBackend.Product;

/**
 * Created by cpritcha on 9/5/17.
 */
public class Product {

    private Integer productId;
    private String productCode;
    private String productName;
    private Double productPrice;
    private Boolean setForDelete;

    public Product() {
        // Emtpy constructor for Hibernate
    }

    public Product(Integer productId, String productCode, String productName, Double productPrice) {
        this.productId = productId;
        this.productCode = productCode;
        this.productName = productName;
        this.productPrice = productPrice;
        this.setForDelete = false;
    }

    public Integer getProductId() { return productId; }
    public String getProductCode() { return productCode; }
    public String getProductName() { return productName; }
    public Double getProductPrice() { return productPrice; }
    public Boolean getSetForDelete() { return setForDelete; }

    public boolean isNew() {
        if(this.getProductId() == null) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (productId != null ? !productId.equals(product.productId) : product.productId != null) return false;
        if (productCode != null ? !productCode.equals(product.productCode) : product.productCode != null) return false;
        if (productName != null ? !productName.equals(product.productName) : product.productName != null) return false;
        if (productPrice != null ? !productPrice.equals(product.productPrice) : product.productPrice != null)
            return false;
        return setForDelete != null ? setForDelete.equals(product.setForDelete) : product.setForDelete == null;
    }

    @Override
    public int hashCode() {
        int result = productId != null ? productId.hashCode() : 0;
        result = 31 * result + (productCode != null ? productCode.hashCode() : 0);
        result = 31 * result + (productName != null ? productName.hashCode() : 0);
        result = 31 * result + (productPrice != null ? productPrice.hashCode() : 0);
        result = 31 * result + (setForDelete != null ? setForDelete.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productCode='" + productCode + '\'' +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", setForDelete=" + setForDelete +
                '}';
    }
}

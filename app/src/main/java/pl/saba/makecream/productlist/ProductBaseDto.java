package pl.saba.makecream.productlist;

import java.io.Serializable;

public class ProductBaseDto implements Serializable {
    private String productName;
    private Integer quantity;

    public ProductBaseDto(String productName, Integer quantity) {
        this.productName = productName;
        this.quantity = quantity;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

}


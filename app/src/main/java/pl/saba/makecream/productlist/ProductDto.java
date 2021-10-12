package pl.saba.makecream.productlist;

import android.graphics.drawable.Drawable;

public class ProductDto {
    private String productName;
    private Drawable productImage;
    private Integer productQuantity = 0;
    private Boolean isProductAddedToOrder = false;
    private Integer typeOfSkin;


    public ProductDto(String productName, Drawable productImage, Integer typeOfSkin) {

        this.productName = productName;
        this.productImage = productImage;
        this.typeOfSkin = typeOfSkin;

    }

    public String getProductName() {
        return this.productName;

    }

    public Drawable getProductImage() {
        return this.productImage;

    }

    public Integer getProductQuantity() {
        return this.productQuantity;
    }

    public void decrementProductQuantity() {
        if (productQuantity != 0) {
            productQuantity = productQuantity - 1;
//            productQuantity--;
        }
    }

    public void incrementProductQuantity() {
        productQuantity = productQuantity + 1;
        if (productQuantity > 3) {
            productQuantity = 3;
        }
    }

    public void addProductToOrder() {
        isProductAddedToOrder = true;
    }

    public void deleteProductFromOrder() {
        isProductAddedToOrder = false;
    }

    public Boolean getProductAddedToOrder() {
        return isProductAddedToOrder;
    }

    public Integer getTypeOfSkin() {
        return this.typeOfSkin;
    }

}

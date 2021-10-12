package pl.saba.makecream.productlist;

public class OrderDto {
    private String orderProductName;
    private String quantity;


    public OrderDto(String orderProductName, String quantity) {

        this.orderProductName = orderProductName;
        this.quantity = quantity;

    }

    public String getOrderProductName() {

        return this.orderProductName;
    }

    public String getQuantity() {
        return this.quantity;
    }
}

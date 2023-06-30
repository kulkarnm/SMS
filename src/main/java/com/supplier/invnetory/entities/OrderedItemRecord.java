package com.supplier.invnetory.entities;

public class OrderedItemRecord {
    private String productId;
    private String orderCount;

    public OrderedItemRecord(String productId, String orderCount) {
        this.productId = productId;
        this.orderCount = orderCount;
    }

    public String getProductId() {
        return productId;
    }

    public String getOrderCount() {
        return orderCount;
    }
}

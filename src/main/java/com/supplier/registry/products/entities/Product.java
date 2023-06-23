package com.supplier.registry.products.entities;

import com.affaince.subscription.common.type.QuantityUnit;

import java.util.List;

public class Product {
    private String productId;
    private String productName;
    private boolean isExchangeable;
    private double netQuantity;
    private QuantityUnit quantityUnit;
    private String supplierName;
    private List<ProductProperties> additionalProperties;

    public Product(String productId, String productName, boolean isExchangeable, double netQuantity, QuantityUnit quantityUnit, String supplierName, List<ProductProperties> additionalProperties) {
        this.productId = productId;
        this.productName = productName;
        this.isExchangeable = isExchangeable;
        this.netQuantity = netQuantity;
        this.quantityUnit = quantityUnit;
        this.supplierName = supplierName;
        this.additionalProperties = additionalProperties;
    }

    public Product() {
    }

    public String getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public boolean isExchangeable() {
        return isExchangeable;
    }

    public double getNetQuantity() {
        return netQuantity;
    }

    public QuantityUnit getQuantityUnit() {
        return quantityUnit;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public List<ProductProperties> getAdditionalProperties() {
        return additionalProperties;
    }
}

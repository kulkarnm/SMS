package com.supplier.registry.products.entities;

public class ProductProperties {
    private String propertyName;
    private Object propertyValue;

    public ProductProperties(String propertyName, Object propertyValue) {
        this.propertyName = propertyName;
        this.propertyValue = propertyValue;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }
}

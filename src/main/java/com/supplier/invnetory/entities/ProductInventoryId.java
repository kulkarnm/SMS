package com.supplier.invnetory.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class ProductInventoryId implements Serializable {
    private String merchantId;
    private String productId;
    private LocalDate inventoryStartDate;
    private LocalDate inventoryEndDate;

    public ProductInventoryId(String merchantId, String productId, LocalDate inventoryStartDate, LocalDate inventoryEndDate) {
        this.merchantId = merchantId;
        this.productId = productId;
        this.inventoryStartDate = inventoryStartDate;
        this.inventoryEndDate = inventoryEndDate;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getProductId() {
        return productId;
    }

    public LocalDate getInventoryStartDate() {
        return inventoryStartDate;
    }

    public LocalDate getInventoryEndDate() {
        return inventoryEndDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductInventoryId that = (ProductInventoryId) o;
        return merchantId.equals(that.merchantId) &&
                productId.equals(that.productId) &&
                inventoryStartDate.equals(that.inventoryStartDate) &&
                inventoryEndDate.equals(that.inventoryEndDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, productId, inventoryStartDate, inventoryEndDate);
    }
}

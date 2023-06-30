package com.supplier.invnetory.entities;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Document
public class ProductInventory {
    @Id
    private ProductInventoryId productInventoryId;
    private long totalDemand;
    private long totalProvision;

    public ProductInventory(String merchantId, String productId, LocalDate startDate,LocalDate endDate){
        this.productInventoryId = new ProductInventoryId(merchantId,productId,startDate,endDate);
    }

    public void addToTotalDemand(long demand){
        this.totalDemand += demand;
    }

    public void addToTotalProvision(long provision){
        this.totalProvision += provision;
    }
    public ProductInventoryId getProductInventoryId() {
        return productInventoryId;
    }

    public long getTotalDemand() {
        return totalDemand;
    }

    public long getTotalProvision() {
        return totalProvision;
    }
}

package com.supplier.invnetory.entities;

import com.supplier.common.IdGenerator;
import com.supplier.invnetory.PurchaseOrderId;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Document
public class PurchaseOrder {
    @Autowired
    IdGenerator idGenerator;
    @Id
    private PurchaseOrderId purchaseOrderId;
    private LocalDate purchaseOrderDate;
    private List<OrderedItemRecord> orderedItemRecords;

    public PurchaseOrder(String merchantId, LocalDate purchaseOrderDate ){
        this.purchaseOrderId = new PurchaseOrderId(merchantId,idGenerator.generator(purchaseOrderDate.toString()));
        this.orderedItemRecords = new ArrayList<>();
    }

    public void addToPurchaseOrderRecord(OrderedItemRecord orderedItemRecord){
        this.orderedItemRecords.add(orderedItemRecord);
    }

    public void addToPurchaseOrderRecord(List<OrderedItemRecord> records){
        this.orderedItemRecords.addAll(records);
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public PurchaseOrderId getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public LocalDate getPurchaseOrderDate() {
        return purchaseOrderDate;
    }

    public List<OrderedItemRecord> getOrderedRecords() {
        return orderedItemRecords;
    }
}

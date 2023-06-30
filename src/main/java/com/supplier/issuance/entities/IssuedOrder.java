package com.supplier.issuance.entities;

import com.supplier.common.IdGenerator;
import com.supplier.invnetory.entities.OrderedItemRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Document
public class IssuedOrder {

    @Id
    private IssuedOrderId issuedOrderId;
    @Autowired
    private IdGenerator idGenerator;
    private LocalDate dateOfIssue;
    private List<OrderedItemRecord> orderedItems;

    public IssuedOrder(String merchantId,LocalDate dateOfIssue){
        this.issuedOrderId = new IssuedOrderId(merchantId,idGenerator.generator(dateOfIssue.toString()));
        this.orderedItems = new ArrayList<>();
    }

    public void addToIssuedOrder(OrderedItemRecord orderedItemRecord){
        this.orderedItems.add(orderedItemRecord);
    }

    public void addToIssuedOrder(List<OrderedItemRecord> orderedItemRecords){
        this.orderedItems.addAll(orderedItemRecords);
    }

    public IssuedOrderId getIssuedOrderId() {
        return issuedOrderId;
    }

    public IdGenerator getIdGenerator() {
        return idGenerator;
    }

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public List<OrderedItemRecord> getOrderedItems() {
        return orderedItems;
    }
}

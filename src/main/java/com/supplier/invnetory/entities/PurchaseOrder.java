package com.supplier.invnetory.entities;

import org.joda.time.LocalDate;

import java.util.List;

public class PurchaseOrder {
    private String purchaseOrderId;
    private LocalDate purchaseOrderDate;
    private List<PurchaseOrderRecord> orderedRecords;
}

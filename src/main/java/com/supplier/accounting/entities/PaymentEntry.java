package com.supplier.accounting.entities;

import org.joda.time.LocalDateTime;

public class PaymentEntry {
    private String transactionReferenceNumber;
    private LocalDateTime dateOfTransaction ;
    private double amount;
    private String paymentDetails;

    public PaymentEntry(String transactionReferenceNumber, LocalDateTime dateOfTransaction, double amount, String paymentDetails) {
        this.transactionReferenceNumber = transactionReferenceNumber;
        this.dateOfTransaction = dateOfTransaction;
        this.amount = amount;
        this.paymentDetails = paymentDetails;
    }

    public String getTransactionReferenceNumber() {
        return transactionReferenceNumber;
    }

    public LocalDateTime getDateOfTransaction() {
        return dateOfTransaction;
    }

    public double getAmount() {
        return amount;
    }

    public String getPaymentDetails() {
        return paymentDetails;
    }
}

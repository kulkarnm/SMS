package com.supplier.accounting.entities;

import org.joda.time.LocalDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class MerchantAccount {
    @Id
    private PeriodWiseMerchantIdentifier periodWiseMerchantIdentifier;
    private List<PaymentEntry> paymentsMade;
    private List<PaymentEntry> paymentsReceived;

    public MerchantAccount(String merchantId, LocalDate startDate,LocalDate endDate) {
        this.periodWiseMerchantIdentifier = new PeriodWiseMerchantIdentifier(merchantId,startDate,endDate);
        this.paymentsMade = new ArrayList<>();
        this.paymentsReceived = new ArrayList<>();
    }

    public void addToPaymentMade(PaymentEntry paymentEntry){
        this.paymentsMade.add(paymentEntry);
    }

    public void addToPaymentsReceived(PaymentEntry paymentReceiptEntry){
        this.paymentsReceived.add(paymentReceiptEntry);
    }

    public double calculateTotalPaymentsMade(){
        return  this.paymentsMade.stream().mapToDouble(pr->pr.getAmount()).sum();
    }

    public double calculateTotalPaymentsReceived(){
        return this.paymentsReceived.stream().mapToDouble(pr->pr.getAmount()).sum();
    }
    public double calculateTotalBalance(){
        return this.paymentsReceived.stream().mapToDouble(pr->pr.getAmount()).sum() - this.paymentsMade.stream().mapToDouble(pr->pr.getAmount()).sum();
    }
}

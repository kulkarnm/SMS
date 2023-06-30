package com.supplier.accounting.entities;

import org.joda.time.LocalDate;

import java.io.Serializable;
import java.util.Objects;

public class PeriodWiseMerchantIdentifier implements Serializable {
    private String merchantId;
    private LocalDate startDate;
    private LocalDate endDate;

    public PeriodWiseMerchantIdentifier(String merchantId, LocalDate startDate, LocalDate endDate) {
        this.merchantId = merchantId;
        this.startDate = startDate;
        this.endDate = endDate;
    }
    public PeriodWiseMerchantIdentifier(){}

    public String getMerchantId() {
        return merchantId;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PeriodWiseMerchantIdentifier that = (PeriodWiseMerchantIdentifier) o;
        return merchantId.equals(that.merchantId) &&
                startDate.equals(that.startDate) &&
                endDate.equals(that.endDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, startDate, endDate);
    }
}

package com.supplier.issuance.entities;

import java.io.Serializable;
import java.util.Objects;

public class IssuedOrderId implements Serializable {
    private String merchantId;
    private String orderId;

    public IssuedOrderId(String merchantId, String orderId) {
        this.merchantId = merchantId;
        this.orderId = orderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getOrderId() {
        return orderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IssuedOrderId that = (IssuedOrderId) o;
        return merchantId.equals(that.merchantId) &&
                orderId.equals(that.orderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, orderId);
    }
}

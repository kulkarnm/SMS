package com.supplier.invnetory;


import java.io.Serializable;
import java.util.Objects;

public class PurchaseOrderId implements Serializable {
    private String merchantId;
    private String purchaseOrderId;

    public PurchaseOrderId(String merchantId, String purchaseOrderId) {
        this.merchantId = merchantId;
        this.purchaseOrderId = purchaseOrderId;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PurchaseOrderId that = (PurchaseOrderId) o;
        return merchantId.equals(that.merchantId) &&
                purchaseOrderId.equals(that.purchaseOrderId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(merchantId, purchaseOrderId);
    }
}

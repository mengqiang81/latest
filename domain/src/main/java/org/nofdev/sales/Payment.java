package org.nofdev.sales;

import org.nofdev.stereotype.AggregateRoot;

import java.math.BigDecimal;

/**
 * 支付单
 */
public class Payment implements AggregateRoot<String> {

    private String id;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public PaymentStatus getPaymentStatus() {
        return paymentStatus;
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    @Override
    public String getEntityId() {
        return getId();
    }
}

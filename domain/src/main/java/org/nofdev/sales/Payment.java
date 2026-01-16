package org.nofdev.sales;

import lombok.Getter;
import lombok.Setter;
import org.nofdev.stereotype.AggregateRoot;

import java.math.BigDecimal;

/**
 * 支付单
 */
@Getter
@Setter
public class Payment implements AggregateRoot<String> {

    private String id;
    private BigDecimal amount;
    private PaymentStatus paymentStatus;

    @Override
    public String getEntityId() {
        return getId();
    }
}

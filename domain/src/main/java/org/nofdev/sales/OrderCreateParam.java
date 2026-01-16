package org.nofdev.sales;

import org.nofdev.address.BasicAddress;
import org.nofdev.stereotype.ValueObject;
import org.nofdev.tenant.TenantId;

import java.util.List;

public record OrderCreateParam(
        List<OrderItem> orderItems,
        BasicAddress basicAddress,
        TenantId tenantId) implements ValueObject {
}

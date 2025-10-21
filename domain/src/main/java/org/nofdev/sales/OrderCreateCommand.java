package org.nofdev.sales;

import org.nofdev.address.BasicAddress;
import org.nofdev.core.CommandObject;
import org.nofdev.tenant.TenantId;

import java.util.List;

public record OrderCreateCommand(
        List<OrderItem> orderItems,
        BasicAddress basicAddress,
        TenantId tenantId) implements CommandObject {
}

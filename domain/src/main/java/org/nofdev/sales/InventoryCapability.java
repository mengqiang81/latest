package org.nofdev.sales;

import org.nofdev.core.DomainSpi;

/**
 * 库存操作SPI
 */
public interface InventoryCapability extends DomainSpi {
    void lockInventory(SalesOrder salesOrder);
}
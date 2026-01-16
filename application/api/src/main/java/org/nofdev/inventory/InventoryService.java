package org.nofdev.inventory;

public interface InventoryService {
    /**
     * 锁定库存
     */
    void lockInventory();

    /**
     * 释放库存
     */
    void releaseInventory();
}

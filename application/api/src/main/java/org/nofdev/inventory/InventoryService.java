package org.nofdev.inventory;

public interface InventoryService {
    /**
     * 锁定库存
     */
    public void lockInventory();

    /**
     * 释放库存
     */
    public void releaseInventory();
}

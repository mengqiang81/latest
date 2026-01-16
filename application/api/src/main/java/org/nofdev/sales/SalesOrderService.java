package org.nofdev.sales;

public interface SalesOrderService {
    void create(OrderCreateCommand orderCreateCommand);
}

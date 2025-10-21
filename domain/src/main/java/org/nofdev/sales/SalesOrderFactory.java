package org.nofdev.sales;

import org.nofdev.core.Factory;

public class SalesOrderFactory implements Factory {
    SalesOrder build(OrderCreateCommand orderCreateCommand) {
//        SalesOrder salesOrder = new SalesOrder();
//        salesOrder.setId(UUID.randomUUID().toString());
//        salesOrder.setOrderDetails(List.copyOf(orderCreateCommand.orderItems()));
//        //XXX validate，只在factory执行validate
        return null;
    }
}

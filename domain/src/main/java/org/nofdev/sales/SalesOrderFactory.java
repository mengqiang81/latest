package org.nofdev.sales;

import org.nofdev.stereotype.Factory;

public class SalesOrderFactory implements Factory {
    SalesOrder build(OrderCreateParam orderCreateParam) {
//        SalesOrder salesOrder = new SalesOrder();
//        salesOrder.setId(UUID.randomUUID().toString());
//        salesOrder.setOrderDetails(List.copyOf(orderCreateParam.orderItems()));
//        //XXX validate，只在factory执行validate
        return null;
    }
}

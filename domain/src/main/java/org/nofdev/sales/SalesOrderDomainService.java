package org.nofdev.sales;

import org.nofdev.stereotype.DomainService;

public class SalesOrderDomainService implements DomainService {
    public void createOrder(OrderCreateParam orderCreateParam) {
        // TODO 占库
        SalesOrderFactory salesOrderFactory = new SalesOrderFactory();
        salesOrderFactory.build(orderCreateParam);
    }
}

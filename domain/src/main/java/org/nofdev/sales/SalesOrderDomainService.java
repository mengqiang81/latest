package org.nofdev.sales;

import org.nofdev.core.DomainService;

public class SalesOrderDomainService implements DomainService {
    public void createOrder(OrderCreateCommand orderCreateCommand) {
        // TODO 占库
        SalesOrderFactory salesOrderFactory = new SalesOrderFactory();
        salesOrderFactory.build(orderCreateCommand);
    }
}

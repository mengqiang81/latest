package org.nofdev.sales;

import java.util.ArrayList;

public class OrderCreateCommandHandler {
    private final SalesOrderDomainService orderDomainService;

    public OrderCreateCommandHandler(SalesOrderDomainService orderDomainService) {
        this.orderDomainService = orderDomainService;
    }

    public void handle(OrderCreateCommand orderCreateCommand) {
        OrderCreateParam orderCreateParam = convert(orderCreateCommand);
        orderDomainService.createOrder(orderCreateParam);
    }

    private OrderCreateParam convert(OrderCreateCommand orderCreateCommand) {
        return new OrderCreateParam(new ArrayList<>(),null,null);
    }
}

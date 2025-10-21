package org.nofdev.sales;

import java.util.ArrayList;

public class SalesOrderServiceImpl implements SalesOrderService {
    private final SalesOrderDomainService orderDomainService;

    public SalesOrderServiceImpl(SalesOrderDomainService orderDomainService) {
        this.orderDomainService = orderDomainService;
    }

    @Override
    public void create(OrderDTO orderDTO) {
        OrderCreateCommand orderCreateCommand = convert(orderDTO);
        orderDomainService.createOrder(orderCreateCommand);
    }

    private OrderCreateCommand convert(OrderDTO orderDTO) {
        return new OrderCreateCommand(new ArrayList<>(),null,null);
    }
}

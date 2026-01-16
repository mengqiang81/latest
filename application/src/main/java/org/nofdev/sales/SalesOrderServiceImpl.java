package org.nofdev.sales;

public class SalesOrderServiceImpl implements SalesOrderService {
    private final OrderCreateCommandHandler orderCreateCommandHandler;

    public SalesOrderServiceImpl(OrderCreateCommandHandler orderCreateCommandHandler) {
        this.orderCreateCommandHandler = orderCreateCommandHandler;
    }

    @Override
    public void create(OrderCreateCommand orderCreateCommand) {
        // TODO，权限校验等
        orderCreateCommandHandler.handle(orderCreateCommand);
    }
}

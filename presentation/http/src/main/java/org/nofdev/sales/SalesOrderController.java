package org.nofdev.sales;

import org.springframework.web.bind.annotation.RestController;
import java.security.Principal;

@RestController
public class SalesOrderController {
    private SalesOrderService salesOrderService;

    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    void create(OrderDTO orderDTO, Principal principal) {
        // TODO, 权限校验（也可以交给网关完成）
        salesOrderService.create(orderDTO);
    }
}

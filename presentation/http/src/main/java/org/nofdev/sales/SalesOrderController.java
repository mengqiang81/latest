package org.nofdev.sales;

import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class SalesOrderController {
    private final SalesOrderService salesOrderService;

    public SalesOrderController(SalesOrderService salesOrderService) {
        this.salesOrderService = salesOrderService;
    }

    void create(OrderCreateCommand orderCreateCommand, Principal principal) {
        // XXX，这里感觉没办法做业务权限校验逻辑，应该交给更下一层去做，这块只能登录态权限校验，接口权限校验等
        // XXX，有一种说法认为简单的RBAC也可以放在这一层，我不是很确定，因为event之类的好像也不需要RBAC认证
        salesOrderService.create(orderCreateCommand);
    }
}

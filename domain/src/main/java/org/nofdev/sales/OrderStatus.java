package org.nofdev.sales;

import lombok.Getter;

/**
 * 订单状态枚举
 * 遵循状态流转规则：DRAFT -> SUBMITTED -> CONFIRMED -> SHIPPED -> DELIVERED
 * 或 DRAFT -> SUBMITTED -> CANCELLED
 */
@Getter
public enum OrderStatus {
    DRAFT("草稿", "订单创建但未提交"),
    SUBMITTED("已提交", "订单已提交但未确认"),
    CONFIRMED("已确认", "订单已确认，库存已锁定"),
    SHIPPED("已发货", "订单商品已发货"),
    DELIVERED("已送达", "订单商品已送达客户"),
    CANCELLED("已取消", "订单已取消，库存已释放");
    private final String name;
    private final String description;

    OrderStatus(String name, String description) {
        this.name = name;
        this.description = description;
    }
}

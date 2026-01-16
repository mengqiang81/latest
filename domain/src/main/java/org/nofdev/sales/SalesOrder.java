package org.nofdev.sales;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.nofdev.address.BasicAddress;
import org.nofdev.common.BasicAggregateTrace;
import org.nofdev.stereotype.AggregateRoot;
import org.nofdev.tenant.Tenantable;
import org.nofdev.custom.FeatureInfo;
import org.nofdev.custom.StaticTenantCustomInfo;
import org.nofdev.customer.CustomerId;
import org.nofdev.tenant.TenantId;


import java.math.BigDecimal;
import java.util.List;

/**
 * 订单
 */
@Getter
@Setter
@Builder
public class SalesOrder implements AggregateRoot<String>, Tenantable {
    private String id;// 销售单ID，聚合内唯一
    private String orderNo;// 销售单编号，租户内唯一

    private CustomerId orderingCustomerId; // 订货客户
    private CustomerId receivingCustomerId; // 收货客户
    private CustomerId payer; // 付款客户
    private CustomerId billingCustomerId; // 结算客户

    private BasicAddress originBasicAddress; // 发货地址
    private BasicAddress shippingBasicAddress; // 收货地址

    private List<OrderItem> orderItems;
    private PaymentStatus paymentStatus;
    private TaxType taxType; // 计税类型

    // XXX, 冗余字段，应该通过商品明细计算, 不能修改
    private BigDecimal totalTaxExcludedAmount;
    private BigDecimal totalTaxAmount;
    private BigDecimal totalTaxIncludedAmount;

    private StaticTenantCustomInfo staticTenantCustomInfo; //需要延迟加载
    private FeatureInfo featureInfo;

    private TenantId tenantId;
    private BasicAggregateTrace basicAggregateTrace;

    @Override
    public String getEntityId() {
        return getId();
    }

    @Override
    public TenantId getTenantId() {
        return this.tenantId;
    }
}

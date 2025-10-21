package org.nofdev.sales;

import jakarta.validation.constraints.*;
import lombok.*;
import org.nofdev.common.BasicEntityTrace;
import org.nofdev.core.Entity;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 建议使用工厂方法，不用工厂方法的话，就是完全信任用户输入，只在最后校验一个总数
 */
@Getter
@Setter
@Builder
public class OrderItem implements Entity<String> {

    @NotEmpty(message = "行号不能为空")
    private String lineNo; // 行号
    @NotEmpty(message = "商品ID不能为空")
    private String itemId; // 商品ID
    @NotNull(message = "不含税单价不能为空")
    private BigDecimal taxExcludedPrice; //不含税单价，必填
    @Positive
    private long quantity; //数量
    @NotNull(message = "不含税金额不能为空")
    private BigDecimal taxExcludedAmount; //不含税金额小计
    @PositiveOrZero(message = "税率不能为负数")
    @NotNull(message = "税率不能为空")
    private BigDecimal taxRate; // 税率
    @NotNull(message = "税额不能为空")
    private BigDecimal taxAmount; // 税额小计, 税额可以通过 含税金额-不含税金额（取整）倒挤
    @NotNull(message = "含税金额不能为空")
    private BigDecimal taxIncludedAmount; //含税金额小计

    private BasicEntityTrace basicEntityTrace;

    @AssertTrue(message = "含税金额等于不含税金额加税额")
    private boolean isAmountConsistent() {
        return taxIncludedAmount.equals(taxExcludedAmount.add(taxAmount));
    }

    /**
     * 工厂方法，按不含税计算含税
     *
     * @param taxExcludedPrice
     * @param quantity
     * @param taxRate
     * @return
     */
    public static OrderItemBuilder ofByExcludeTax(BigDecimal taxExcludedPrice, long quantity, BigDecimal taxRate) {
        BigDecimal taxExcludedAmount = taxExcludedPrice.multiply(BigDecimal.valueOf(quantity)).setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxAmount = taxExcludedAmount.multiply(taxRate).setScale(2, RoundingMode.HALF_UP);
        BigDecimal taxIncludedAmount = taxExcludedAmount.add(taxAmount);
        OrderItemBuilder builder = OrderItem.builder();
        builder.taxExcludedAmount = taxExcludedAmount;
        builder.taxAmount = taxAmount;
        builder.taxIncludedAmount = taxIncludedAmount;
        return builder;
    }

    /**
     * 工厂方法，按含税倒挤税额
     *
     * @param taxExcludedPrice
     * @param quantity
     * @param taxIncludedAmount
     * @return
     */
    public static OrderItemBuilder ofByIncludeTax(BigDecimal taxExcludedPrice, long quantity, BigDecimal taxIncludedAmount) {
        BigDecimal taxExcludedAmount = taxExcludedPrice.multiply(BigDecimal.valueOf(quantity));
        BigDecimal taxAmount = taxIncludedAmount.subtract(taxExcludedAmount);
        OrderItemBuilder builder = OrderItem.builder();
        builder.taxExcludedAmount = taxExcludedAmount;
        builder.taxAmount = taxAmount;
        return builder;
    }

    @Override
    public String getEntityId() {
        return getLineNo();
    }
}

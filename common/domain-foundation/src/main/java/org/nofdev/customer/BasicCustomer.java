package org.nofdev.customer;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.nofdev.core.ValueObject;

/**
 * 基础客户信息，可冗余
 *
 * @param id 客户ID，全局唯一
 * @param customerNo 客户编码，租户内唯一
 * @param name
 * @param type
 */
public record BasicCustomer(
        @NotNull
        CustomerId id,
        @NotBlank
        String customerNo,
        @NotBlank
        String name,
        @NotNull
        CustomerType type) implements ValueObject {
}

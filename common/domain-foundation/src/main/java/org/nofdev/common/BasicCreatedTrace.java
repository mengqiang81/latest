package org.nofdev.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.nofdev.core.ValueObject;

import java.time.OffsetDateTime;

/**
 * 创建节点基础视图，对应生命周期初始化INITIALIZED
 *
 * @param dateCreated 创建时间
 * @param createdBy   创建人
 */
public record BasicCreatedTrace(
        @NotNull
        OffsetDateTime dateCreated,
        @NotBlank
        String createdBy
) implements ValueObject {

}

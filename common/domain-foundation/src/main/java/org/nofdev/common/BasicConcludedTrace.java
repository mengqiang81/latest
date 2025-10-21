package org.nofdev.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.nofdev.core.ValueObject;

import java.time.OffsetDateTime;

/**
 * 完结节点基础视图，包括生命周期完成COMPLETED和终止TERMINATED
 *
 * @param dateConcluded 完结时间
 * @param concludedBy   完结人
 */
public record BasicConcludedTrace(
        @NotNull
        OffsetDateTime dateConcluded,
        @NotBlank
        String concludedBy
) implements ValueObject {
}
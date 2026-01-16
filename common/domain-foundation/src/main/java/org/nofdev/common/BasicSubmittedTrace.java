package org.nofdev.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.nofdev.stereotype.ValueObject;

import java.time.OffsetDateTime;

/**
 * 提交节点基础视图，对应生命周期待确认PENDING_CONFIRM
 *
 * @param dateSubmitted 提交时间
 * @param submittedBy   提交人
 */
public record BasicSubmittedTrace(
        @NotNull
        OffsetDateTime dateSubmitted,
        @NotBlank
        String submittedBy
) implements ValueObject {
}
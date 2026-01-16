package org.nofdev.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.nofdev.stereotype.ValueObject;

import java.time.OffsetDateTime;

/**
 * 确认节点基础视图，对应生命周期已确认CONFIRMED
 *
 * @param dateConfirmed 确认时间
 * @param confirmedBy   确认人
 */
public record BasicConfirmedTrace(
        @NotNull
        OffsetDateTime dateConfirmed,
        @NotBlank
        String confirmedBy
) implements ValueObject {

}

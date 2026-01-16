package org.nofdev.common;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.nofdev.stereotype.ValueObject;

import java.time.OffsetDateTime;

/**
 * 更新节点基础视图，对应生命周期中的每一次变化，包括草稿态的多次保存，包括标记删除
 *
 * @param lastUpdated   最后更新时间
 * @param lastUpdatedBy 最后更新人
 * @param version       版本号，用于乐观锁
 * @param deleted       逻辑/标记删除，本质上是对数据删除状态的更新，并且受乐观锁影响
 */
public record BasicUpdatedTrace(
        @NotNull
        OffsetDateTime lastUpdated,
        @NotBlank
        String lastUpdatedBy,
        long version,
        boolean deleted
) implements ValueObject {
}
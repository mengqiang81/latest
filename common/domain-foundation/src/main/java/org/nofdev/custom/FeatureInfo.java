package org.nofdev.custom;

import jakarta.validation.constraints.Size;
import org.nofdev.core.ValueObject;

/**
 * 针对二开的自定义字段，二开开发技术使用，由二开自己定义数据结构和规则。
 * 不支持检索
 *
 * @param value
 */
public record FeatureInfo(
        @Size(max = 5000)
        String value) implements ValueObject {
}

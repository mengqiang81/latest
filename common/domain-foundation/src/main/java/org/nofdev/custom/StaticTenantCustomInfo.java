package org.nofdev.custom;

import jakarta.validation.constraints.Size;
import org.nofdev.core.ValueObject;

/**
 * 静态租户自定义信息（主要是静态自定义字段），支持检索
 * 对于领域层，租户自定义信息只是用来透传，它如何被持久化和如何被使用的不是领域层的职责范围，所以使用最高压缩比的字段存储内容
 * 实际基础设施层，会使用protobuf格式
 * 持久化时会对应到数据库的自定义表的字段，可以针对json字段进行索引，对二开性能友好
 * 需要在元数据层面持久化protobuf的schema信息，在应用和持久化时读取元数据中的schema进行序列化和反序列化，要遵循protobuf的兼容性定义
 * 这里面的信息在get时会延迟加载
 * XXX，这个地方如果value需要很大的话，还要结合protobuf的分隔符流Delimited（protobuf其实依赖连续的内存块，对流式也不是特别友好），改为InputStream，防止OOM，大小限制100K以内先不动
 * XXX，需要元数据层配合大小测算，比如根据字段类型，测算最大大小，提前提示用户，比如超过100k内容使用对象存储
 * t_ai_voucher表56个字段，一行大概在15k以内，mysql默认页大小16k，postgresql为8k，行大小其超过50%则大字段溢出存储，所以这个地方设置不能超过16k问题不大（少量toast），差不多留给二开50个字段用于扩展
 *
 * @param value
 */
public record StaticTenantCustomInfo(
        @Size(max = 16 * 1024) byte[] value
) implements ValueObject {
}

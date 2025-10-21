package org.nofdev.custom;

import org.nofdev.core.ValueObject;

/**
 * 静态租户自定义信息（主要是静态自定义字段），支持检索
 * 对于领域层，租户自定义信息只是用来透传，它如何被持久化和如何被使用的不是领域层的职责范围，所以使用最高压缩比的字段存储内容
 * 实际基础设施层，会使用protobuf格式
 * 持久化时会对应到数据库的自定义表的字段，可以针对json字段进行索引，对二开性能友好
 * 需要在元数据层面持久化protobuf的schema信息，在应用和持久化时读取元数据中的schema进行序列化和反序列化，要遵循protobuf的兼容性定义
 * 这里面的信息在get时会延迟加载
 *
 * @param value
 */
public record StaticTenantCustomInfo(
        byte[] value
) implements ValueObject {
}

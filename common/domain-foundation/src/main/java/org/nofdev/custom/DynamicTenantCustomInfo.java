package org.nofdev.custom;

import java.util.Map;

/**
 * 动态租户自定义信息（主要是动态自定义字段），轻量扩展
 * 对于领域层，租户自定义信息只是用来透传，它如何被持久化和如何被使用的不是领域层的职责范围，所以使用最高压缩比的字段存储内容
 * 持久化时会对应到数据库的自定义表的jsonb字段
 * XXX，在特定情况下支持检索
 * XXX，感觉暂时不要支持这种，用个字符串的feature应该够了，或者这个能力标品直接支持，不要二开支持了
 * XXX，jakarta.validation注解不支持MapSize
 *
 * @param value
 */
public record DynamicTenantCustomInfo(Map<String, Object> value) {
}

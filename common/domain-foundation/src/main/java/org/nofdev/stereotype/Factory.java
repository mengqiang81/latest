package org.nofdev.stereotype;

/**
 * 为了保障领域对象创建即合法，可以在factory中进行校验
 * 可以引入JSR380定义，validator的具体实现在基础设施层
 * Factory主要用于创建聚合根，也可以用于创建复杂子实体，创建子实体时，不能脱离聚合根而存在
 */
public interface Factory<AggregateRoot> {
}

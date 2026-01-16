package org.nofdev.stereotype;

/**
 * 聚合根
 * 聚合根ID在聚合中全局唯一（而非租户内唯一），并且就是实体ID
 * 是事务边界和 Repository 管理的对象
 */
public interface AggregateRoot<ID> extends Entity<ID> {
}

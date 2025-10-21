package org.nofdev.core;

/**
 * 聚合根
 * 聚合根ID在聚合中全局唯一（而非租户内唯一），并且就是实体ID
 * 是事务边界和 Repository 管理的对象
 */
public interface AggregateRoot<ID> extends Entity<ID> {
//    /**
//     * 为了加强语义，定义了获取聚合根ID的方法
//     * 这个方法不应该被重写，因为聚合根ID就是实体ID，这在DDD中是确定的
//     * XXX 还没找到方法怎么防止getAggregateId()不被重写
//     *
//     * @return
//     */
//    default ID getAggregateId() {
//        return getEntityId();
//    }
}

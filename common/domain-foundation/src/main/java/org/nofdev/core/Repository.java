package org.nofdev.core;

import java.util.List;
import java.util.Optional;

/**
 * 领域层通用repository接口，只能传入聚合根，不能传入实体
 *
 * @param <T>
 * @param <ID>
 */
public interface Repository<T extends AggregateRoot<ID>, ID> {
    // 仅将对象加入内存集合，不立即持久化
    void add(T aggregateRoot);

    // 从内存集合中移除对象
    void remove(ID id);

    // 从内存或存储中获取对象
    Optional<T> get(ID id);

    // 获取内存中所有已跟踪的对象（供工作单元批量处理）
    List<T> getTrackedAggregateRoots();
}

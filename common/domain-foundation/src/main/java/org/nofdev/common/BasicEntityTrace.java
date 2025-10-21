package org.nofdev.common;

/**
 * 子实体基本信息
 * 定义了一组子实体的极简共性，建议在子实体(比如分录)上添加，子实体对于生命周期的完整性记录要求可以低一些
 * 注意，主实体更新并不一定意味着子实体更新，这里子实体的创建和更新状态独立于主实体
 * 对于聚合根，参考 {@link BasicAggregateTrace}
 */
public class BasicEntityTrace {
    /**
     * @see BasicCreatedTrace
     */
    private BasicCreatedTrace basicCreatedTrace;
    /**
     * @see BasicUpdatedTrace
     */
    private BasicUpdatedTrace basicUpdatedTrace;
}

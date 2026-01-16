package org.nofdev.stereotype;

/**
 * 一个实体有ID，有独立的生命周期跟踪，但它不一定是一个聚合根，它可能是一个聚合根中的子实体，它也没有repo，子实体ID只在聚合根中唯一
 *
 * @param <ID> DDD中并没有要求ID是可被序列化的，但是工程实践中建议ID extends Serializable
 */
public interface Entity<ID> {
    ID getEntityId();
}
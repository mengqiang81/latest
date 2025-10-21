package org.nofdev.core;

/**
 * command具有双重概念，要注意区分跟CQRS里的区别
 * 在领域层的command表达领域操作的意图和规则，通常行为逻辑由聚合根实现，不需要再搞个CommandHandler
 * Query在应用层无异议，应用层是否定义command和commandHandler看情况吧，我们还是把重点放在领域层
 */
public interface CommandObject {
}

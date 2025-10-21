package org.nofdev.core;

/**
 * 领域层在跟外部交互时需要定义SPI，由应用层实现
 * SPI的入参可以使用领域层里的领域对象等，因为领域层为核心，其他层为领域层服务，所以不需要再定义什么额外的DTO对象了
 */
public interface DomainSpi {
}

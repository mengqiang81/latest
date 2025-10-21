package org.nofdev.tenant;

import org.nofdev.core.ValueObject;

/**
 * 在多租户架构中，租户值对象应该全公司共享，所以强制定义了租户编码，而其他地方虽然也推荐用编码，但是不强制。
 * 尽可能避免过度设计，能关联Tenant域的领域对象就好了。
 *
 * @param value 业务编码，非数据库ID
 */
public record TenantId(String value) implements ValueObject {
}

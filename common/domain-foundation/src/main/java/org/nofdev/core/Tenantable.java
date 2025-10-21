package org.nofdev.core;

import org.nofdev.tenant.TenantId;

/**
 * 具备租户ID的领域对象
 */
public interface Tenantable {
    TenantId getTenantId();
}

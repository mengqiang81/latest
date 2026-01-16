package org.nofdev.tenant;

/**
 * 具备租户ID的领域对象
 */
public interface Tenantable {
    TenantId getTenantId();
}

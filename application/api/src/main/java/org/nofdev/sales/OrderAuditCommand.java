package org.nofdev.sales;

public record OrderAuditCommand(String orderId, String operatorName) {
}

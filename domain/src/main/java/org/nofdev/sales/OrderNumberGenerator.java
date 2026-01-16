package org.nofdev.sales;

import org.nofdev.stereotype.DomainService;

import java.util.UUID;

public class OrderNumberGenerator implements DomainService {
    private static final String PREFIX = "SO";

    String generate() {
        return PREFIX + UUID.randomUUID();
    }

}

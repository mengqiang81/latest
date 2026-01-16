package org.nofdev.customer;

import org.nofdev.stereotype.ValueObject;

public record CustomerId(String value) implements ValueObject {
}

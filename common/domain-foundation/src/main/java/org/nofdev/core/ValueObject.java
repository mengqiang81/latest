package org.nofdev.core;

public interface ValueObject<T> {
    default boolean theSameAs(T t) {
        return this.equals(t);
    }
}

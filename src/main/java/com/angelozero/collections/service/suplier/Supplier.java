package com.angelozero.collections.service.suplier;

@FunctionalInterface
public interface Supplier<T> {
    T get();
}

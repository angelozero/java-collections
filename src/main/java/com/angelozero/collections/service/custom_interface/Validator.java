package com.angelozero.collections.service.custom_interface;

@FunctionalInterface
public interface Validator<T> {
    boolean isValid(T t);

    // This is not possible because a functional interface has exactly one abstract method.
    // boolean isInvalid(T t);
}

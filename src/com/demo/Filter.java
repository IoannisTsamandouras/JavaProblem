package com.demo;

public interface Filter<T,E> {
    public boolean isMatched(T object, E text);
}
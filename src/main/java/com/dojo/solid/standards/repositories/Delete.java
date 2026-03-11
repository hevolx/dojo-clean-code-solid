package com.dojo.solid.standards.repositories;

public interface Delete<K> {
    boolean delete(K id);
}

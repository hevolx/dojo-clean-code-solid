package com.dojo.solid.standards.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T, K> {
    boolean add(T element);
    List<T> findAll();
    Optional<T> findById(K id);
}

package com.dojo.solid.standards.repositories;

import java.util.Optional;

public interface FindById<T, K> {
    Optional<T> findById(K id);
}

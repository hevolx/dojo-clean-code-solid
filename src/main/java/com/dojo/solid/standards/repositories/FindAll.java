package com.dojo.solid.standards.repositories;

import java.util.List;

public interface FindAll<T> {
    List<T> findAll();
}

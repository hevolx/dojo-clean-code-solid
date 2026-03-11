package com.dojo.solid.standards.repositories;

import java.util.List;
import java.util.Optional;

// TODO (Exercise 4 - ISP): This interface is too large. It groups add, findAll, findById and delete
//  into one single contract. Clients that only need to read data are forced to depend on the
//  write/delete operations as well.
//
//  The new "delete" method below is causing compilation errors in every repository implementation
//  because none of them need to support deletion.
//
//  Fix: Split this interface into smaller role interfaces (e.g. Add<T>, FindAll<T>, FindById<T,K>,
//  Delete<T,K>) so that each repository only implements what it actually needs.
public interface Repository<T, K> {
    boolean add(T element);
    List<T> findAll();
    Optional<T> findById(K id);
    boolean delete(K id); // This breaks ALL existing implementations!
}

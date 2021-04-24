package org.example.dao;


import java.util.List;
import java.util.Optional;

public interface Dao<K,E> {

    List<E> findAll();

    Optional<E> findById(K id);

    void update(E city);

    E save(E city);

    boolean delete(K id);
}

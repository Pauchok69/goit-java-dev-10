package org.example.services.crud;

import java.util.List;

public interface CrudService<ID, T> {
    void insert(T entity);

    void update(T entity);

    T find(ID id);

    List<T> findAll();

    void delete(T entity);
}

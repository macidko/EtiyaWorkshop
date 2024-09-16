package org.example.core;

public interface EntityRepositoryDao<T extends Entity> {
    void add(T entity);
    void delete(int id);
    void update(T entity);
    T getById(int id);
}

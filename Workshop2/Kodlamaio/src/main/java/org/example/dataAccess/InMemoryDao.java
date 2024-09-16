package org.example.dataAccess;

import org.example.core.Entity;
import org.example.core.EntityRepositoryDao;

import java.util.HashMap;
import java.util.Map;

public class InMemoryDao<T extends Entity> implements EntityRepositoryDao<T> {
    private Map<Integer, T> storage = new HashMap<>();

    @Override
    public void add(T entity) {
        storage.put(entity.getId(), entity);
    }

    @Override
    public void delete(int id) {
        storage.remove(id);
    }

    @Override
    public void update(T entity) {
        storage.put(entity.getId(), entity);
    }

    public T getById(int id)
    {
        return storage.get(id);
    }
}

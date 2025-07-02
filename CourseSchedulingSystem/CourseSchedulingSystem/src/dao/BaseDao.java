package dao;

import java.util.List;

public interface BaseDao<T> {
    boolean add(T item);
    boolean delete(String id);
    boolean update(T item);
    T getById(String id);
    List<T> getAll();
}


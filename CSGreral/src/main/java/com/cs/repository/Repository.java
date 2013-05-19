package com.cs.repository;

import java.util.List;

public interface Repository<T> {

    public void saveOrUpdate(T modelo);

    public void delete(T modelo);

    public List<T> findAll();

    public T findById(Long id);
}

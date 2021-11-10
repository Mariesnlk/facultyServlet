package com.example.faculty.dao.interf;

import java.util.List;

public interface CrudDao<E, K> {

    void create(E entity);

    E findById(K id);

    List<E> findAll();

    void update(E entity);

    boolean delete(E entity);

}

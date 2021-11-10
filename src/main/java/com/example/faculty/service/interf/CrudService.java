package com.example.faculty.service.interf;

import java.util.List;

public interface CrudService<E, K> {

    void create(E entity);

    E findById(K id);

    List<E> findAll();

    void update(E entity);

    boolean delete(E entity);

}

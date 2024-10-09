package com.codegym.service;

import java.util.Optional;

public interface IGenerateService<T>{
    Iterable<T> findAll();
    void save(T t);

    Optional<T> findById(Long id);

    void remove(Long id);
}

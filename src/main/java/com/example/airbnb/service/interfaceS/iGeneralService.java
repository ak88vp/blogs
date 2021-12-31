package com.example.airbnb.service.interfaceS;

import java.util.Optional;

public interface iGeneralService<T> {
    Iterable<T> findAll();
    Optional<T> findById(Long id);
    void save(T t);
    void remove(Long id);
}

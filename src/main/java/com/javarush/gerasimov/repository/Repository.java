package com.javarush.gerasimov.repository;

import java.util.List;

public interface Repository<T> {
    List<T> findAll();
}

package com.example.hospital.repository;

import com.example.hospital.model.HasId;
import java.util.List;
public interface BaseRepo<T extends HasId> {
    void save(T object);
    List<T> findAll();
    T findById(String id);
    void delete(String id);
}

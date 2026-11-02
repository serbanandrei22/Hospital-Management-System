package com.example.hospital.repository;

import com.example.hospital.model.HasId;

import java.util.ArrayList;
import java.util.List;

public abstract class InMemoryRepository<T extends HasId> implements BaseRepository<T> {
    protected List<T> objects;
    public InMemoryRepository(){
        this.objects=new ArrayList<>();
    }
    @Override
    public void save(T object){
        delete(object.getId());
        this.objects.add(object);
    }
    @Override
    public List<T> findAll(){
        return new ArrayList<>(this.objects);
    }
    @Override
    public T findById(String id){
        for (T obj: this.objects){
            if(obj.getId() != null && obj.getId().equals(id)){
                return obj;
            }
        }
        return null;
    }
    @Override
    public void delete(String id){
        this.objects.removeIf(obj-> obj.getId() != null && obj.getId().equals(id));
    }
}

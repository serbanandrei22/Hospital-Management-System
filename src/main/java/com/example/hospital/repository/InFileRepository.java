package com.example.hospital.repository;

import com.example.hospital.model.HasId;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class InFileRepository<T extends HasId> {
    protected final String filePath;
    protected final Class<T> entityType;
    protected final ObjectMapper objectMapper;

    public InFileRepository(String filePath, Class<T> entityType) {
        this.filePath = filePath;
        this.entityType = entityType;
        this.objectMapper = new ObjectMapper();
        this.objectMapper.registerModule(new JavaTimeModule());
    }

    public List<T> findAll() {
        try {
            File file = new File(filePath);
            if (!file.exists() || file.length() == 0) return new ArrayList<>();
            return objectMapper.readValue(file, objectMapper.getTypeFactory().constructCollectionType(List.class, entityType));
        } catch (IOException e) {
            return new ArrayList<>();
        }
    }

    protected void saveAll(List<T> items) {
        try {
            objectMapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), items);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public T findById(String id) {
        return findAll().stream()
                .filter(item -> getEntityId(item).equals(id))
                .findFirst()
                .orElse(null);
    }

    public void save(T item) {
        List<T> items = findAll();

        String id = getEntityId(item);
        if (id == null || id.trim().isEmpty()) {
            int maxId = 0;
            for (T existingItem : items) {
                try {
                    String existingId = getEntityId(existingItem);
                    int numericId = Integer.parseInt(existingId);
                    if (numericId > maxId) {
                        maxId = numericId;
                    }
                } catch (NumberFormatException e) {
                }
            }
            id = String.valueOf(maxId + 1);
            setEntityId(item, id);
        }

        String finalId = id;
        items.removeIf(existing -> getEntityId(existing).equals(finalId));
        items.add(item);

        saveAll(items);
    }

    public void delete(String id) {
        List<T> items = findAll();
        items.removeIf(item -> getEntityId(item).equals(id));

        int index = 1;
        for (T item : items) {
            String currentId = getEntityId(item);
            try {
                Integer.parseInt(currentId);
                setEntityId(item, String.valueOf(index));
                index++;
            } catch (NumberFormatException e) {
            }
        }

        saveAll(items);
    }

    private String getEntityId(T item) {
        return item.getId() != null ? item.getId() : "";
    }

    private void setEntityId(T item, String id) {
        item.setId(id);
    }
}
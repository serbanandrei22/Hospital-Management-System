package com.example.hospital.repository;

import com.example.hospital.model.Room;
import org.springframework.stereotype.Repository;

import java.util.zip.Inflater;

@Repository
public class RoomRepository extends InFileRepository<Room> {

    public RoomRepository() {
        super("src/main/resources/data/Room.json", Room.class);
    }
}

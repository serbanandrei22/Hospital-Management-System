package com.example.hospital.service;

import com.example.hospital.model.Room;
import com.example.hospital.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomService {
    private final RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository){
        this.roomRepository= roomRepository;
    }

    public void saveRoom(Room room){
        roomRepository.save(room);
    }
    public Room getRoomById(String id){
        return roomRepository.findById(id);
    }
    public List<Room> getAllRooms(){
        return roomRepository.findAll();
    }
    public void deleteRoom(String id){roomRepository.delete(id);}


}

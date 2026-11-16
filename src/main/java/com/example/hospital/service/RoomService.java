package com.example.hospital.service;

import com.example.hospital.model.Room;
import com.example.hospital.model.Hospital;
import com.example.hospital.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class RoomService {
    private final RoomRepository roomRepository;
    private final HospitalService hospitalService;

    public RoomService(RoomRepository roomRepository,HospitalService hospitalService){
        this.roomRepository= roomRepository;
        this.hospitalService=hospitalService;
    }

    public void saveRoom(Room room){
        if (room.getHospitalId() != null && !room.getHospitalId().isEmpty()) {
            Hospital h = hospitalService.getHospitalById(room.getHospitalId());
            if (h == null) {
                throw new IllegalArgumentException("Eroare: Spitalul cu ID-ul " + room.getHospitalId() + " nu exista!");
            }
        }
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

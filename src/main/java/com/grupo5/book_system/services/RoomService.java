package com.grupo5.book_system.services;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.repositories.ClientRepository;
import com.grupo5.book_system.repositories.RoomRepository;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    @Autowired
    RoomRepository repository;

    public List<Room> findALL(){
        List<Room> rooms = repository.findAll();
        return rooms;
    }
    public Room findByRoomNumber(Integer idNumber){
        Optional<Room> rooms = repository.findById(idNumber);
        return rooms.orElseThrow(() -> new ResourceNotFoundException (idNumber));
    }
}

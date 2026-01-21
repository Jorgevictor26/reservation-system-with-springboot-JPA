package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/rooms")
public class RoomResource {

    @Autowired
    RoomService roomService;

    @GetMapping
    public ResponseEntity<List<Room>> findAll(){
        List<Room> rooms = roomService.findALL();
        return ResponseEntity.ok().body(rooms);
    }

    @GetMapping(value = "/{idNumber}")
    public ResponseEntity<Room> findaByRoomNumber(@PathVariable Integer idNumber){
        Room room = roomService.findByRoomNumber(idNumber);
        return ResponseEntity.ok().body(room);
    }

}

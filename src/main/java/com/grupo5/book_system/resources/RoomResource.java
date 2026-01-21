package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.services.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Integer id){
        roomService.DeletedById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Room> update(@PathVariable Integer id, @RequestBody Room room){
         Room newRoom = roomService.Update(id, room);
        return ResponseEntity.ok().body(newRoom);
    }

    @PostMapping
    public ResponseEntity<Room> insert(@RequestBody Room room) {
        room = roomService.insert(room);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(room.getRoomNumber()).toUri();
        return ResponseEntity.created(uri).body(room);
    }

}

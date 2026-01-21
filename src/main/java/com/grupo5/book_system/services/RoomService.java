package com.grupo5.book_system.services;

import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.repositories.RoomRepository;
import com.grupo5.book_system.services.exceptions.DatabaseException;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {
    final
    RoomRepository repository;

    public RoomService(RoomRepository repository) {
        this.repository = repository;
    }

    public Room insert(Room room) {
        return repository.save(room);
    }

    public Room findByRoomNumber(Integer id) {
        Optional<Room> rooms = repository.findById(id);
        return rooms.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Room> findALL() {
        return repository.findAll();
    }

    public void DeletedById(Integer id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public Room Update(Integer id, Room room) {
        try {
            Room entity = repository.getReferenceById(id);
            updateData(entity, room);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Room entity, Room room) {
        entity.setRoomStatus(room.getRoomStatus());
        entity.setRoomType(room.getRoomType());
        entity.setCapacity(room.getCapacity());
        entity.setBaseDailyPrice(room.getBaseDailyPrice());
    }
}

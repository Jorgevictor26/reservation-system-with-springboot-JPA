package com.grupo5.book_system.repositories;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Integer> {
}

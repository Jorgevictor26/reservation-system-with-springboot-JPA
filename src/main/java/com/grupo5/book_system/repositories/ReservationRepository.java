package com.grupo5.book_system.repositories;

import com.grupo5.book_system.entities.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
}

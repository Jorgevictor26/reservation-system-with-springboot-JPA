package com.grupo5.book_system.services;

import com.grupo5.book_system.entities.Reservation;
import com.grupo5.book_system.entities.Room;
import com.grupo5.book_system.entities.enums.ReservationStatus;
import com.grupo5.book_system.repositories.ReservationRepository;
import com.grupo5.book_system.services.exceptions.BussinessException;
import com.grupo5.book_system.services.exceptions.DatabaseException;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {
    final
    ReservationRepository repository;

    public ReservationService(ReservationRepository repository) {
        this.repository = repository;
    }

    public Reservation insert(Reservation reservation) {

        checkDateOverlap(reservation.getRoom(), reservation.getCheckinDate(), reservation.getCheckOutDate());
        return repository.save(reservation);
    }

    public Reservation findByIdNumber(Long id) {
        Optional<Reservation> reservation = repository.findById(id);
        return reservation.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Reservation> findALL() {
        return repository.findAll();
    }

    public void DeletedById(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new ResourceNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataAccessException e) {
            throw new DatabaseException(e.getMessage());
        }
    }


    public Reservation Update(Long id, Reservation reservation) {
        try {
            Reservation entity = repository.getReferenceById(id);
            updateData(entity, reservation);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Reservation entity, Reservation reservation) {
        entity.setClient(reservation.getClient());
        entity.setRoom(reservation.getRoom());
        entity.setCheckinDate(reservation.getCheckinDate());
        entity.setCheckOutDate(reservation.getCheckOutDate());
    }

    public void cancel(Long id) {
        Reservation reservation = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id));
        if (reservation.getReservationStatus() != ReservationStatus.CONFIRMED) {
            throw new BussinessException("U cannot cancel, Status: " + reservation.getReservationStatus());
        }
        reservation.setReservationStatus(ReservationStatus.CANCELED);
        repository.save(reservation);
    }

    public void checkIn(Long id) {
        Reservation reservation = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if (reservation.getReservationStatus() != ReservationStatus.CONFIRMED) {
            throw new BussinessException("Invalid CheckIn. Status: " + reservation.getReservationStatus());
        }

        reservation.setReservationStatus(ReservationStatus.CHECKED_IN);
        repository.save(reservation);
    }

    public void checkOut(Long id) {
        Reservation reservation = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));

        if (reservation.getReservationStatus() != ReservationStatus.CHECKED_IN) {
            throw new BussinessException("Invalid CheckOut. Status: " + reservation.getReservationStatus());
        }

        reservation.setReservationStatus(ReservationStatus.CHECKED_IN);
        repository.save(reservation);
    }

    private void checkDateOverlap(Room room, LocalDate dataCheckIn, LocalDate dataCheckOut) {
        for (Reservation r : repository.findAll()) {
            if (r.getRoom().equals(room)
                    && dataCheckIn.isBefore(r.getCheckOutDate())
                    && dataCheckOut.isAfter(r.getCheckinDate())) {
                throw new BussinessException("The room will be rented at this time");
            }
        }
    }

}

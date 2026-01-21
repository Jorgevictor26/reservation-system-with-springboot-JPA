package com.grupo5.book_system.services;
import com.grupo5.book_system.entities.Reservation;
import com.grupo5.book_system.entities.Reservation;
import com.grupo5.book_system.repositories.ReservationRepository;
import com.grupo5.book_system.repositories.ReservationRepository;
import com.grupo5.book_system.services.exceptions.DatabaseException;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

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
        return repository.save(reservation);
    }

    public Reservation findByIdNumber(Long id) {
        Optional<Reservation> reservation = repository.findById(id);
        return reservation.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Reservation> findALL() {
        return repository.findAll();
    }

    public void DeletedById(Long idNumber) {
        try {
            repository.deleteById(idNumber);
        } catch (EmptyResultDataAccessException e) {
            throw new ResourceNotFoundException(idNumber);
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

}

package com.grupo5.book_system.services;

import com.grupo5.book_system.entities.Payment;
import com.grupo5.book_system.repositories.PaymentRepository;
import com.grupo5.book_system.repositories.RoomRepository;
import com.grupo5.book_system.services.exceptions.DatabaseException;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PaymentService {
    final
    PaymentRepository repository;

    public PaymentService(PaymentRepository repository) {
        this.repository = repository;
    }

    public Payment insert(Payment payment) {
        return repository.save(payment);
    }

    public Payment findById(Long id) {
        Optional<Payment> payments = repository.findById(id);
        return payments.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Payment> findALL() {
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

    public Payment Update(Long id, Payment payment) {
        try {
            Payment entity = repository.getReferenceById(id);
            updateData(entity, payment);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Payment entity, Payment payment) {
        entity.setServiceType(payment.getServiceType());
        entity.setQuantity(payment.getQuantity());
    }
}

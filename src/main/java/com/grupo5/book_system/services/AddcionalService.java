package com.grupo5.book_system.services;

import com.grupo5.book_system.entities.AddicionalService;
import com.grupo5.book_system.entities.enums.PaymentMethod;
import com.grupo5.book_system.repositories.AddicionalRepository;
import com.grupo5.book_system.services.exceptions.DatabaseException;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddcionalService {
    final
    AddicionalRepository repository;

    public AddcionalService(AddicionalRepository repository) {
        this.repository = repository;
    }

    public AddicionalService insert(AddicionalService addicionalService) {
        return repository.save(addicionalService);
    }

    public AddicionalService findById(Long id) {
        Optional<com.grupo5.book_system.entities.AddicionalService> payments = repository.findById(id);
        return payments.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<AddicionalService> findALL() {
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

    public AddicionalService Update(Long id, AddicionalService addicionalService) {
        try {
           AddicionalService entity = repository.getReferenceById(id);
            updateData(entity, addicionalService);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(AddicionalService entity, AddicionalService addicionalService) {
        entity.setServiceType(addicionalService.getServiceType());
        entity.setQuantity(addicionalService.getQuantity());
    }
}

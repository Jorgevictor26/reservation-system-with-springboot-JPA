package com.grupo5.book_system.services;
import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.repositories.ClientRepository;
import com.grupo5.book_system.services.exceptions.DatabaseException;
import com.grupo5.book_system.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    final
    ClientRepository repository;

    public ClientService(ClientRepository repository) {
        this.repository = repository;
    }

    public Client insert(Client client) {
        return repository.save(client);
    }

    public Client findByIdNumber(Long id) {
        Optional<Client> client = repository.findById(id);
        return client.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public List<Client> findALL() {
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


    public Client Update(Long id, Client client) {
        try {
            Client entity = repository.getReferenceById(id);
            updateData(entity, client);
            return repository.save(entity);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException(id);
        }
    }

    private void updateData(Client entity, Client client) {
        entity.setName(client.getName());
        entity.setSurname(client.getSurname());
        entity.setEmail(client.getEmail());
        entity.setPhone(client.getPhone());
    }

}

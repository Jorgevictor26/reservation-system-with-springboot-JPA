package com.grupo5.book_system.services;

import com.grupo5.book_system.entities.Client;
import com.grupo5.book_system.repositories.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientService {
    @Autowired
    ClientRepository repository;

    public List<Client> findALL(){
        List<Client> clients = repository.findAll();
        return clients;
    }
    public Client findByIdNumber(String idNumber){
        Optional<Client> client = repository.findById(idNumber);
        return client.orElseThrow(RuntimeException::new);
    }
}

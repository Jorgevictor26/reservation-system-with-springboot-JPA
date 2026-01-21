package com.grupo5.book_system.repositories;

import com.grupo5.book_system.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}

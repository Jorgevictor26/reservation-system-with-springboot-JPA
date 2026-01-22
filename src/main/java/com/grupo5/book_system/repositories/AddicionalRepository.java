package com.grupo5.book_system.repositories;

import com.grupo5.book_system.entities.AddicionalService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddicionalRepository extends JpaRepository<AddicionalService, Long> {
}

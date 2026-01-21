package com.grupo5.book_system.repositories;

import com.grupo5.book_system.entities.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}

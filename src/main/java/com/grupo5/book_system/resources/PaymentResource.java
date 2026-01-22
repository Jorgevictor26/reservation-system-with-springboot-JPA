package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Payment;
import com.grupo5.book_system.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/payments")
public class PaymentResource {

    @Autowired
    PaymentService paymentervice;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll(){
        List<Payment> payments = paymentervice.findALL();
        return ResponseEntity.ok().body(payments);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment payment = paymentervice.findById(id);
        return ResponseEntity.ok().body(payment);
    }

    @PostMapping
    public ResponseEntity<Payment> insert(@RequestBody Payment payment) {
        payment = paymentervice.insert(payment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(uri).body(payment);
    }

}

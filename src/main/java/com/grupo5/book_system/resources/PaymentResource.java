package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Payment;
import com.grupo5.book_system.services.ClientService;
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
    PaymentService paymentService;

    @GetMapping
    public ResponseEntity<List<Payment>> findAll() {
        List<Payment> payments = paymentService.findALL();
        return ResponseEntity.ok().body(payments);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Payment> findaById(@PathVariable Long id) {
        Payment payment = paymentService.findById(id);
        return ResponseEntity.ok().body(payment);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Payment> update(@PathVariable Long id, @RequestBody Payment payment) {
        payment = paymentService.Update(id, payment);
        return ResponseEntity.ok().body(payment);
    }
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        paymentService.DeletedById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Payment> insert(@RequestBody Payment payment) {
        payment = paymentService.insert(payment);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(payment.getId()).toUri();
        return ResponseEntity.created(uri).body(payment);
    }

}

package com.grupo5.book_system.resources;

import com.grupo5.book_system.entities.Reservation;
import com.grupo5.book_system.services.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/reservations")
public class ReservationResource {

    @Autowired
    ReservationService reservationService;

    @GetMapping
    public ResponseEntity<List<Reservation>> findAll() {
        List<Reservation> reservations = reservationService.findALL();
        return ResponseEntity.ok().body(reservations);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Reservation> findaByIdNumber(@PathVariable Long id) {
        Reservation reservation = reservationService.findByIdNumber(id);
        return ResponseEntity.ok().body(reservation);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Long id, @RequestBody Reservation reservation) {
        reservation = reservationService.Update(id, reservation);
        return ResponseEntity.ok().body(reservation);
    }

    @PutMapping(value = "/{id}/cancel")
    public ResponseEntity<Void> cancel(@PathVariable Long id){
        reservationService.cancel(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}/checkin")
    public ResponseEntity<Void>checkIn(@PathVariable Long id){
        reservationService.checkIn(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping(value = "/{id}/checkout")
    public ResponseEntity<Void>checkOut(@PathVariable Long id){
        reservationService.checkOut(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id){
        reservationService.DeletedById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping
    public ResponseEntity<Reservation> insert(@RequestBody Reservation reservation) {
        reservation = reservationService.insert(reservation);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(reservation.getReservationCode()).toUri();
        return ResponseEntity.created(uri).body(reservation);
    }

}

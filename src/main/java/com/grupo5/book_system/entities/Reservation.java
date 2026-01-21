package com.grupo5.book_system.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.grupo5.book_system.entities.enums.ReservationStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_reservation")
public class Reservation implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationCode;

    private LocalDate checkinDate;
    private LocalDate checkOutDate;
    private Integer reservationStatus;
    private Integer numberOfGuests;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy HH:mm", timezone = "UTC")
    private LocalDateTime creationDate;

    @ManyToOne
    @JoinColumn(name = "FK_client")
    private Client client;

    @ManyToOne
    @JoinColumn(name = "FK_room")
    private Room room;

    public Reservation(Long reservationCode, LocalDate checkinDate, LocalDate checkOutDate,
                       ReservationStatus reservationStatus, Integer numberOfGuests,
                       Client client, Room room) {

        this.reservationCode = reservationCode;
        this.checkinDate = checkinDate;
        this.checkOutDate = checkOutDate;
        setReservationStatus(reservationStatus);
        this.numberOfGuests = numberOfGuests;
        this.creationDate = LocalDateTime.now();
        this.client = client;
        this.room = room;
    }

    public void setReservationStatus(ReservationStatus reservationStatus) {
        if (reservationStatus != null) {
            this.reservationStatus = reservationStatus.getCode();
        }
    }

    public ReservationStatus getReservationStatus() {
        return ReservationStatus.valueOf(reservationStatus);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Reservation that = (Reservation) o;
        return Objects.equals(reservationCode, that.reservationCode);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(reservationCode);
    }
}

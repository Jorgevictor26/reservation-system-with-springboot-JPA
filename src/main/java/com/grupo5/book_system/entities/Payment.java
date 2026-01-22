package com.grupo5.book_system.entities;

import com.grupo5.book_system.entities.enums.Method;
import com.grupo5.book_system.entities.enums.PaymentStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_payment")
public class Payment implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double paidValue;
    private LocalDateTime paymentDate;
    private Integer method;
    private Integer paymentStatus;

    @ManyToOne
    @JoinColumn(name = "FK_reservation")
    Reservation reservation;

    public void setMethod(Method method) {
        this.method = method.getCode();
    }

    public Method getMethod() {
        return Method.valueOf(method);
    }

    public void setPaymentStatus(PaymentStatus paymentStatus) {
        if (paymentStatus != null) {
            this.paymentStatus = paymentStatus.getCode();
        }
    }

    public PaymentStatus getPaymentStatus() {
        return PaymentStatus.valueOf(paymentStatus);
    }

}

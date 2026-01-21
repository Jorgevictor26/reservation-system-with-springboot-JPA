package com.grupo5.book_system.entities;

import com.grupo5.book_system.entities.enums.PaymentMethod;
import com.grupo5.book_system.entities.enums.ServiceType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

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

    private String description;
    private Integer serviceType;
    private Double unitPrice;
    private Integer quantity;
    private Integer paymentMethod;

    public Payment(Long id, String description, ServiceType serviceType, Double unitPrice,
                   Integer quantity, PaymentMethod paymentMethod) {
        this.id = id;
        this.description = description;
        setPaymentMethod(paymentMethod);
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        setServiceType(serviceType);
    }

    @ManyToOne
    @JoinColumn(name = "FK_reservation")
    Reservation reservation;


    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType.getCode();
    }

    public ServiceType getServiceType() {
        return ServiceType.valueOf(serviceType);
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        if(paymentMethod!=null)
        {
            this.paymentMethod = paymentMethod.getCode();
        }
    }

    public PaymentMethod getPaymentMethod() {
        return PaymentMethod.valueOf(paymentMethod);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Payment payment = (Payment) o;
        return Objects.equals(id, payment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

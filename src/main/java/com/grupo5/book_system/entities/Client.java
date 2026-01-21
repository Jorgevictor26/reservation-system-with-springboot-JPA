package com.grupo5.book_system.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serial;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "tb_client")
public class Client implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    String idNumber;

    String name;
    String surname;
    String email;
    String phone;

    public Client(String idNumber, String name, String surname, String email, String phone) {
        this.idNumber = idNumber;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(idNumber, client.idNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idNumber);
    }
}

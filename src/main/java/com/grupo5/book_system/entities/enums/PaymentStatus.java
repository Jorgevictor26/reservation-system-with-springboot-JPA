package com.grupo5.book_system.entities.enums;

public enum PaymentStatus {
    PENDENTE(1),
    CONFIRMADO(2),
    ESTORNADO(3);

    private int code;

    PaymentStatus(int code) {
        this.code = code;
    }

    public static PaymentStatus valueOf(int code) {
        for (PaymentStatus status : PaymentStatus.values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid Status");
    }

    public Integer getCode() {
        return code;
    }
}

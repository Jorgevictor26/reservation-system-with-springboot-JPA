package com.grupo5.book_system.entities.enums;

public enum PaymentMethod {
    PER_NIGHT(1),
    FIXED(2),
    PER_UNIT(3);

    private int code;

    PaymentMethod(int code) {
        this.code = code;
    }

    public static PaymentMethod valueOf(int code) {
        for (PaymentMethod status : PaymentMethod.values()) {
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

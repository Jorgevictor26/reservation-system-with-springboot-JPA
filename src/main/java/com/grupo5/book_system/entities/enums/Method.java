package com.grupo5.book_system.entities.enums;

public enum Method {
    CASH(1),
    CREDIT_CARD(2),
    BANK_TRANSFER(3);

    private int code;

    Method(int code) {
        this.code = code;
    }

    public static Method valueOf(int code) {
        for (Method status : Method.values()) {
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

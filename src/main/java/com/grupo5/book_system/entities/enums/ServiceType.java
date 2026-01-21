package com.grupo5.book_system.entities.enums;

public enum ServiceType {
    BREAKFAST(1),
    LAUNDRY(2),
    TRANSPORTATION(3),
    OTHER(4);

    private int code;

    ServiceType(int code) {
        this.code = code;
    }

    public static ServiceType valueOf(int code) {
        for (ServiceType status : ServiceType.values()) {
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

package com.grupo5.book_system.entities.enums;

public enum RoomStatus {
    ACTIVE(1),
    INACTIVE(2),
    MAINTENANCE(3);

    private int code;

    RoomStatus(int code) {
        this.code = code;
    }

    public static RoomStatus valueOf(int code) {
        for (RoomStatus status : RoomStatus.values()) {
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

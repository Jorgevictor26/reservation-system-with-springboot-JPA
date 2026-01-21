package com.grupo5.book_system.entities.enums;

public enum ReservationStatus {
    CREATED(1),
    CONFIRMED(2),
    CANCELED(3),
    CHECKED_IN(4),
    CHECKED_OUT(5);

    private int code;

    ReservationStatus(int code){
        this.code = code;
    }

    public static ReservationStatus valueOf(int code)
    {
        for(ReservationStatus value : ReservationStatus.values()){
            if(value.getCode() == code){
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Status");
    }
    public int getCode() {
        return code;
    }
}

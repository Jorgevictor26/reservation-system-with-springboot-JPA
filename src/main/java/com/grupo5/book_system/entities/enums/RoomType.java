package com.grupo5.book_system.entities.enums;

public enum RoomType {
    STANDARD(1),
    DELUXE(2),
    SUITE(3);

    private int code;

    RoomType(int code){
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public static RoomType valueOf( int code){
        for(RoomType type : RoomType.values()){
            if(type.getCode() == code){
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid Type!!");
    }
}


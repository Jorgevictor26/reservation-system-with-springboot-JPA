package com.grupo5.book_system.entities;

import com.grupo5.book_system.entities.enums.RoomStatus;
import com.grupo5.book_system.entities.enums.RoomType;
import jakarta.persistence.*;
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
@Table(name = "tb_room")
public class Room implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roomNumber;

    private Integer roomType;
    private Double baseDailyPrice;
    private Integer capacity;
    private Integer roomStatus;

    public Room(Integer roomNumber, RoomType roomType, Double baseDailyPrice, Integer capacity, RoomStatus roomStatus) {
        this.roomNumber = roomNumber;
        setRoomType(roomType);
        this.baseDailyPrice = baseDailyPrice;
        this.capacity = capacity;
        setRoomStatus(roomStatus);
    }

    public void setRoomStatus(RoomStatus roomStatus) {
        if (roomStatus != null) {
            this.roomStatus = roomStatus.getCode();
        }
    }

    public RoomStatus getRoomStatus() {
        return RoomStatus.valueOf(roomStatus);
    }

    public void setRoomType(RoomType roomType) {
        if(roomType != null){
            this.roomType = roomType.getCode();
        }
    }

    public RoomType getRoomType(){
        return RoomType.valueOf(roomType);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(roomNumber, room.roomNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(roomNumber);
    }
}

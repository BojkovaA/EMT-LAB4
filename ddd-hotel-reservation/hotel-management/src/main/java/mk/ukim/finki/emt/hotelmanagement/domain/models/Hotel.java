package mk.ukim.finki.emt.hotelmanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "hotel")
@Getter
public class Hotel extends AbstractEntity<HotelId> {
    private String hotelName;
    private String address;
    private String phoneNumber;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Room> roomList = new HashSet<>();

    protected Hotel() {
        super(HotelId.randomId(HotelId.class));
    }

    public Hotel(String hotelName) {
        super(HotelId.randomId(HotelId.class));
        this.hotelName = hotelName;
    }

    public Room addRoom(@NonNull String roomNumber, @NonNull RoomType roomType) {
        Objects.requireNonNull(roomNumber, "Room number must not be null");
        var room = new Room(roomNumber, roomType);
        roomList.add(room);
        return room;
    }

    public void removeRoom(@NonNull RoomId roomId) {
        Objects.requireNonNull(roomId, "Room ID must not be null");
        roomList.removeIf(room -> room.getId().equals(roomId));
    }

}

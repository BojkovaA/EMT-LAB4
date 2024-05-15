package mk.ukim.finki.emt.hotelmanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.hotelmanagement.domain.models.RoomId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name = "room")
@Getter
public class Room  extends AbstractEntity<RoomId> {

    private String roomNumber;
    private RoomType roomType;

    protected Room() {
        super(RoomId.randomId(RoomId.class));
    }

    public Room(@NonNull String roomNumber, @NonNull RoomType roomType) {
        super(RoomId.randomId(RoomId.class));
        this.roomNumber = roomNumber;
        this.roomType = roomType;
    }
}

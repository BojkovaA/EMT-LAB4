package mk.ukim.finki.emt.reservationmanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
@Embeddable
public class RoomId extends DomainObjectId {
    public RoomId() {
        super(RoomId.randomId(RoomId.class).getId());
    }

    public RoomId(String uuid) {
        super(uuid);
    }
}

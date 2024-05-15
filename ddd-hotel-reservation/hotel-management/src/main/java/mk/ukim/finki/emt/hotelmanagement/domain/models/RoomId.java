package mk.ukim.finki.emt.hotelmanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class RoomId extends DomainObjectId {

    private RoomId() {
        super(RoomId.randomId(RoomId.class).getId());
    }

    public RoomId(String uuid) {
        super(uuid);
    }
}

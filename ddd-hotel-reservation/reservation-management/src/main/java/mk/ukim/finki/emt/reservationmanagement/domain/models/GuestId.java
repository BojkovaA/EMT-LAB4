package mk.ukim.finki.emt.reservationmanagement.domain.models;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
@Embeddable
public class GuestId extends DomainObjectId {
    private GuestId() {
        super(GuestId.randomId(GuestId.class).getId());
    }

    public GuestId(String uuid) {
        super(uuid);
    }
}

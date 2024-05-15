package mk.ukim.finki.emt.reservationmanagement.domain.models;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;
@Embeddable
public class ReservationId extends DomainObjectId {

    private ReservationId() {
        super(ReservationId.randomId(ReservationId.class).getId());
    }

    public ReservationId(String uuid) {
        super(uuid);
    }
}

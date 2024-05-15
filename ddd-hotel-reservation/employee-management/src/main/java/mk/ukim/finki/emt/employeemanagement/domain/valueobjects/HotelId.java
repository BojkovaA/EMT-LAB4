package mk.ukim.finki.emt.employeemanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

@Embeddable
public class HotelId extends DomainObjectId {

    public HotelId() {
        super(HotelId.randomId(HotelId.class).getId());
    }

    public HotelId(String uuid) {
        super(uuid);
    }

}

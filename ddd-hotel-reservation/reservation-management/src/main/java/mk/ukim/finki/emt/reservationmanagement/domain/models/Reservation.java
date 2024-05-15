package mk.ukim.finki.emt.reservationmanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import mk.ukim.finki.emt.reservationmanagement.domain.valueobjects.RoomId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDate;

@Entity
@Table(name = "reservation")
@Getter
public class Reservation extends AbstractEntity<ReservationId> {

    private LocalDate reservationDate;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Money price;
    @Enumerated(EnumType.STRING)
    private PaymentType paymentType;

    @AttributeOverride(name = "id", column = @Column(name = "room_id", nullable = false))
    private RoomId roomId;

    protected Reservation() {
        super(ReservationId.randomId(ReservationId.class));
    }

    public Reservation(LocalDate reservationDate, LocalDate checkInDate, LocalDate checkOutDate, Money price, PaymentType paymentType, RoomId roomId) {
        super(ReservationId.randomId(ReservationId.class));
        this.reservationDate = reservationDate;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.price = price;
        this.paymentType = paymentType;
        this.roomId = roomId;
    }

}

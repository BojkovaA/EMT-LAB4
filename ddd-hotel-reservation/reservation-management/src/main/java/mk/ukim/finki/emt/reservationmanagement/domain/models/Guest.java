package mk.ukim.finki.emt.reservationmanagement.domain.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.reservationmanagement.domain.valueobjects.RoomId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "guest")
@Getter
public class Guest extends AbstractEntity<GuestId> {

    private String firstName;
    private String lastName;
    private String passportNumber;
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<Reservation> reservationsList = new HashSet<>();

    protected Guest() {
        super(GuestId.randomId(GuestId.class));
    }

    public Guest(String firstName, String lastName, String passportNumber) {
        super(GuestId.randomId(GuestId.class));
        this.firstName = firstName;
        this.lastName = lastName;
        this.passportNumber = passportNumber;
    }

    public Reservation addReservation(@NonNull LocalDate reservationDate, @NonNull LocalDate checkInDate, @NonNull LocalDate checkOutDate, @NonNull Money price, @NonNull PaymentType paymentType, @NonNull RoomId roomId) {
        Objects.requireNonNull(reservationDate, "Room number must not be null");
        var reservation = new Reservation(reservationDate, checkInDate, checkOutDate, price, paymentType, roomId);
        reservationsList.add(reservation);
        return reservation;
    }

    public void removeReservation(ReservationId reservationId) {
        reservationsList.removeIf(reservation -> reservation.getId().equals(reservationId));
    }
}

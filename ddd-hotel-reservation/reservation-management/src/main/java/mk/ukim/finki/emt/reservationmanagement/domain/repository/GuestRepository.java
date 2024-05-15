package mk.ukim.finki.emt.reservationmanagement.domain.repository;

import mk.ukim.finki.emt.reservationmanagement.domain.models.Guest;
import mk.ukim.finki.emt.reservationmanagement.domain.models.GuestId;
import mk.ukim.finki.emt.reservationmanagement.domain.models.Reservation;
import mk.ukim.finki.emt.reservationmanagement.domain.models.ReservationId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestRepository extends JpaRepository<Guest, GuestId> {
}

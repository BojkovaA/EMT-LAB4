package mk.ukim.finki.emt.reservationmanagement.service;

import mk.ukim.finki.emt.reservationmanagement.domain.exceptions.GuestIdNotExistException;
import mk.ukim.finki.emt.reservationmanagement.domain.models.*;
import mk.ukim.finki.emt.reservationmanagement.domain.valueobjects.RoomId;
import mk.ukim.finki.emt.reservationmanagement.service.form.GuestForm;
import mk.ukim.finki.emt.reservationmanagement.service.form.ReservationForm;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import java.util.List;
import java.util.Optional;

public interface GuestService {

    GuestId createGuest(GuestForm guestForm);

    List<Guest> findAllGuests();

    Optional<Guest> findGuestById(GuestId id);

    void addReservation(GuestId guestId, ReservationForm reservationForm) throws GuestIdNotExistException;

}
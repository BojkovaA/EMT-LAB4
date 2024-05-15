package mk.ukim.finki.emt.reservationmanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.reservationmanagement.domain.exceptions.GuestIdNotExistException;
import mk.ukim.finki.emt.reservationmanagement.domain.models.*;
import mk.ukim.finki.emt.reservationmanagement.domain.repository.GuestRepository;
import mk.ukim.finki.emt.reservationmanagement.domain.valueobjects.RoomId;
import mk.ukim.finki.emt.reservationmanagement.service.GuestService;
import mk.ukim.finki.emt.reservationmanagement.service.form.GuestForm;
import mk.ukim.finki.emt.reservationmanagement.service.form.ReservationForm;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import javax.validation.ConstraintViolationException;
import org.springframework.stereotype.Service;

import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class GuestServiceImpl implements GuestService {

    private final GuestRepository guestRepository;
    private final Validator validator;

    @Override
    public GuestId createGuest(GuestForm guestForm) {
        Objects.requireNonNull(guestForm, "Guest form must not be null.");
        var constraintViolations = validator.validate(guestForm);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The guest form is not valid", constraintViolations);
        }
        var newGuest = guestRepository.saveAndFlush(toDomainObject(guestForm));
        return newGuest.getId();
    }

    @Override
    public List<Guest> findAllGuests() {
        return guestRepository.findAll();
    }

    @Override
    public Optional<Guest> findGuestById(GuestId id) {
        return guestRepository.findById(id);
    }

    @Override
    public void addReservation(GuestId guestId, ReservationForm reservationForm) {
        Guest guest = guestRepository.findById(guestId).orElseThrow(GuestIdNotExistException::new);
        guest.addReservation(reservationForm.getReservationDate(), reservationForm.getCheckInDate(), reservationForm.getCheckOutDate(), reservationForm.getPrice(), reservationForm.getPaymentType(), reservationForm.getRoomId());
        guestRepository.saveAndFlush(guest);
    }


    private Guest toDomainObject(GuestForm guestForm) {
        return new Guest(guestForm.getFirstName(), guestForm.getLastName(), guestForm.getPassportNumber());
    }

//    private Reservation toDomainObject(ReservationForm reservationForm) {
//        return new Reservation(
//                reservationForm.getReservationDate(),
//                reservationForm.getCheckInDate(),
//                reservationForm.getCheckOutDate(),
//                reservationForm.getPrice(),
//                reservationForm.getPaymentType(),
//                reservationForm.getRoomId()
//        );
//    }
}

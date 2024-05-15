package mk.ukim.finki.emt.reservationmanagement.service.form;

import lombok.Data;
import mk.ukim.finki.emt.reservationmanagement.domain.models.PaymentType;
import mk.ukim.finki.emt.reservationmanagement.domain.valueobjects.RoomId;
import mk.ukim.finki.emt.sharedkernel.domain.dates.DateRange;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ReservationForm {

    @NotNull
    private LocalDate reservationDate;

    @NotNull
    private LocalDate checkInDate;

    @NotNull
    private LocalDate checkOutDate;

    @NotNull
    private Money price;

    @NotNull
    private PaymentType paymentType;

    @NotNull
    private RoomId roomId;
}

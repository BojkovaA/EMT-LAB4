package mk.ukim.finki.emt.reservationmanagement.service.form;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

@Data
public class GuestForm {

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;

    @NotEmpty
    private String passportNumber;

    @Valid
    @NotEmpty
    private List<ReservationForm> reservationForms = new ArrayList<>();
}
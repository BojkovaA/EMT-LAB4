package mk.ukim.finki.emt.hotelmanagement.service.form;

import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Min;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;


@Data
public class HotelForm {

    @NotNull
    @NotEmpty
    private String name;

    @NotNull
    private String address;

    @NotNull
    private String phoneNumber;

    @Valid
    @NotEmpty
    private List<RoomForm> roomFormList = new ArrayList<>();
}
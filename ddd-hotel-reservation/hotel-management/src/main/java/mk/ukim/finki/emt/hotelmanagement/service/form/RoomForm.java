package mk.ukim.finki.emt.hotelmanagement.service.form;

import lombok.Data;
import mk.ukim.finki.emt.hotelmanagement.domain.models.Hotel;
import mk.ukim.finki.emt.hotelmanagement.domain.models.RoomType;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class RoomForm {

    @NotNull
    @NotEmpty
    private String roomNumber;

    @NotNull
    private RoomType roomType;

}
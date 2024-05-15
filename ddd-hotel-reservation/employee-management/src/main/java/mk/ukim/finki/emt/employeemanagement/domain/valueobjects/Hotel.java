package mk.ukim.finki.emt.employeemanagement.domain.valueobjects;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

@Getter
public class Hotel implements ValueObject {

    private final HotelId id;
    private final String name;

    private Hotel() {
        this.id = HotelId.randomId(HotelId.class);
        this.name = "";
    }

    @JsonCreator
    public Hotel(@JsonProperty("id") HotelId id,
                 @JsonProperty("name") String name) {
        this.id = id;
        this.name = name;
    }
}

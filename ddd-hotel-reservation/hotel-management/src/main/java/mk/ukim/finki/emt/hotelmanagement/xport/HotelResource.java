package mk.ukim.finki.emt.hotelmanagement.xport;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.hotelmanagement.domain.models.Hotel;
import mk.ukim.finki.emt.hotelmanagement.service.HotelService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/hotel")
@AllArgsConstructor
public class HotelResource {

    private final HotelService hotelService;

    @GetMapping
    public List<Hotel> getAll() {
        return hotelService.findAll();
    }
}

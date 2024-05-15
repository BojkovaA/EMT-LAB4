package mk.ukim.finki.emt.reservationmanagement.xport;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.reservationmanagement.domain.models.Guest;
import mk.ukim.finki.emt.reservationmanagement.service.GuestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/guest")
@AllArgsConstructor
public class GuestResource {

    private final GuestService guestService;

    @GetMapping
    public List<Guest> getAll() {
        return guestService.findAllGuests();
    }
}

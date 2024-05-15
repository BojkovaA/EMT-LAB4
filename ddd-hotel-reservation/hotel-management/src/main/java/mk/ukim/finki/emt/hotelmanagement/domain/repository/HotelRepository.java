package mk.ukim.finki.emt.hotelmanagement.domain.repository;

import mk.ukim.finki.emt.hotelmanagement.domain.models.Hotel;
import mk.ukim.finki.emt.hotelmanagement.domain.models.HotelId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, HotelId> {
}

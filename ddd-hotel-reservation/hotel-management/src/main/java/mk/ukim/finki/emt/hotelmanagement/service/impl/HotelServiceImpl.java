package mk.ukim.finki.emt.hotelmanagement.service.impl;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.hotelmanagement.domain.exception.HotelIdNotExistException;
import mk.ukim.finki.emt.hotelmanagement.domain.exception.RoomIdNotExistException;
import mk.ukim.finki.emt.hotelmanagement.domain.models.Hotel;
import mk.ukim.finki.emt.hotelmanagement.domain.models.HotelId;
import mk.ukim.finki.emt.hotelmanagement.domain.models.RoomId;
import mk.ukim.finki.emt.hotelmanagement.domain.repository.HotelRepository;
import mk.ukim.finki.emt.hotelmanagement.service.HotelService;
import mk.ukim.finki.emt.hotelmanagement.service.form.HotelForm;
import mk.ukim.finki.emt.hotelmanagement.service.form.RoomForm;
import org.springframework.stereotype.Service;

import javax.validation.ConstraintViolationException;
import javax.validation.Validator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
@Transactional
@AllArgsConstructor
public class HotelServiceImpl implements HotelService {

    private final HotelRepository hotelRepository;
    private final Validator validator;

    @Override
    public HotelId createHotel(HotelForm hotelForm) {
        Objects.requireNonNull(hotelForm, "Hotel form must not be null.");
        var constraintViolations = validator.validate(hotelForm);
        if (constraintViolations.size() > 0) {
            throw new ConstraintViolationException("The hotel form is not valid", constraintViolations);
        }
        var newHotel = hotelRepository.saveAndFlush(toDomainObject(hotelForm));
        return newHotel.getId();
    }

    @Override
    public List<Hotel> findAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Optional<Hotel> findById(HotelId id) {
        return hotelRepository.findById(id);
    }

    @Override
    public void addRoom(HotelId hotelId, RoomForm roomForm) throws HotelIdNotExistException {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(HotelIdNotExistException::new);
        hotel.addRoom(roomForm.getRoomNumber(), roomForm.getRoomType());
        hotelRepository.saveAndFlush(hotel);
    }

    @Override
    public void removeRoom(HotelId hotelId, RoomId roomId) throws HotelIdNotExistException, RoomIdNotExistException {
        Hotel hotel = hotelRepository.findById(hotelId).orElseThrow(HotelIdNotExistException::new);
        hotel.removeRoom(roomId);
        hotelRepository.saveAndFlush(hotel);
    }

    private Hotel toDomainObject(HotelForm hotelForm) {
        return new Hotel(hotelForm.getName());
    }
}
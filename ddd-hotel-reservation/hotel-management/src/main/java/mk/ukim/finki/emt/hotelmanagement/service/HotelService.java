package mk.ukim.finki.emt.hotelmanagement.service;

import mk.ukim.finki.emt.hotelmanagement.domain.exception.HotelIdNotExistException;
import mk.ukim.finki.emt.hotelmanagement.domain.exception.RoomIdNotExistException;
import mk.ukim.finki.emt.hotelmanagement.domain.models.Hotel;
import mk.ukim.finki.emt.hotelmanagement.domain.models.HotelId;
import mk.ukim.finki.emt.hotelmanagement.domain.models.RoomId;
import mk.ukim.finki.emt.hotelmanagement.service.form.HotelForm;
import mk.ukim.finki.emt.hotelmanagement.service.form.RoomForm;

import java.util.List;
import java.util.Optional;

public interface HotelService {

    HotelId createHotel(HotelForm hotelForm);

    List<Hotel> findAll();

    Optional<Hotel> findById(HotelId id);

    void addRoom(HotelId hotelId, RoomForm roomForm) throws HotelIdNotExistException;

    void removeRoom(HotelId hotelId, RoomId roomId) throws HotelIdNotExistException, RoomIdNotExistException;
}
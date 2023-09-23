package com.hotel.microservice.service;

import com.hotel.microservice.dto.HotelDto;

import java.util.List;

public interface HotelService {

    HotelDto createHotel(HotelDto hotelDto);

    HotelDto findHotelById(int hotelId);

    List<HotelDto> getAllHotels();

}

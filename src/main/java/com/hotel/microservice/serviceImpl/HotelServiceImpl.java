package com.hotel.microservice.serviceImpl;

import com.hotel.microservice.dto.HotelDto;
import com.hotel.microservice.entity.Hotel;
import com.hotel.microservice.exception.ResourceNotFoundException;
import com.hotel.microservice.repository.HotelRepo;
import com.hotel.microservice.service.HotelService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class HotelServiceImpl implements HotelService {

    @Autowired
    private HotelRepo hotelRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public HotelDto createHotel(HotelDto hotelDto) {
        Hotel map = this.modelMapper.map(hotelDto, Hotel.class);
        Hotel save = this.hotelRepo.save(map);
        return this.modelMapper.map(save, HotelDto.class);
    }

    @Override
    public HotelDto findHotelById(int hotelId) {
        Hotel hotel = this.hotelRepo.findById(hotelId).orElseThrow(() -> new ResourceNotFoundException("hotel", "hotelId", hotelId));
        return this.modelMapper.map(hotel, HotelDto.class);
    }

    @Override
    public List<HotelDto> getAllHotels() {

        List<Hotel> all = this.hotelRepo.findAll();
        return all.stream().map(hotel->this.modelMapper.map(hotel, HotelDto.class)).collect(Collectors.toList());
    }
}

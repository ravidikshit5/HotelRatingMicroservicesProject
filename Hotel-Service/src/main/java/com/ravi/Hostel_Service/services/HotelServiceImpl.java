package com.ravi.Hostel_Service.services;

import com.ravi.Hostel_Service.entities.Hotel;
import com.ravi.Hostel_Service.exceptions.ResourceNotFoundException;
import com.ravi.Hostel_Service.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel createHotel(Hotel hotel) {
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotel() {
        return hotelRepository.findAll();

    }

    @Override
    public Hotel getById(String id) {
       return hotelRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Hotel with this id is not available"));
//        return null;
    }
}

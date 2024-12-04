package com.ravi.Hostel_Service.services;

import com.ravi.Hostel_Service.entities.Hotel;

import java.util.List;

public interface HotelService {
    //create hotel
    Hotel createHotel(Hotel hotel);

    //getAll hotel
    List<Hotel> getAllHotel();

    //get single
    Hotel getById(String id);
}

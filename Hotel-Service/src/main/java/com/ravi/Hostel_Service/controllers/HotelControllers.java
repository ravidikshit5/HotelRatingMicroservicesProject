package com.ravi.Hostel_Service.controllers;

import com.ravi.Hostel_Service.entities.Hotel;
import com.ravi.Hostel_Service.services.HotelServiceImpl;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotel")
public class HotelControllers {
    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping("/save")
    public ResponseEntity<Hotel> saveHotel(@RequestBody Hotel hotel){
        Hotel hotel1 = hotelService.createHotel(hotel);
        return new ResponseEntity<>(hotel1,HttpStatus.CREATED);
    }
    @GetMapping("/getAllHotels")
    public ResponseEntity<List<Hotel>> getAll(){
        List<Hotel> hotels = hotelService.getAllHotel();
        return new ResponseEntity<>(hotels,HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Hotel> getById(@PathVariable String id){
        Hotel hotel = hotelService.getById(id);
        return new ResponseEntity<>(hotel,HttpStatus.OK);
    }
}

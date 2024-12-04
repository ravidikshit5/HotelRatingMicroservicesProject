package com.ravi.Rating_Service.controllers;

import com.ravi.Rating_Service.entities.Rating;
import com.ravi.Rating_Service.services.impl.ImplRatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingControler {

    @Autowired
    private ImplRatingService ratingService;
    @PostMapping("/createRating")
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating){
        Rating rating1 = ratingService.createRating(rating);
        return new ResponseEntity<>(rating1, HttpStatus.CREATED);
        //return ResponseEntity.status(HttpStatus.CREATED).body(ratingService.createRating(rating));
    }
    @GetMapping("/getAllRating")
    public ResponseEntity<List<Rating>> getAllRating(){
        List<Rating> ratings = ratingService.getAllRating();
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/userId/{userId}")
    public ResponseEntity<List<Rating>> getAllRatingByUserId(@PathVariable String userId){
        List<Rating> ratings = ratingService.getAllRatingByUserId(userId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
    @GetMapping("/hotelId/{hotelId}")
    public ResponseEntity<List<Rating>> getAllRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratings = ratingService.getAllRatingByHotelId(hotelId);
        return new ResponseEntity<>(ratings,HttpStatus.OK);
    }
}

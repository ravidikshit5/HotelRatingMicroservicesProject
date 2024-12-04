package com.ravi.Rating_Service.services;


import com.ravi.Rating_Service.entities.Rating;

import java.util.List;

public interface RatingService {
    //create Rating
   public Rating createRating(Rating rating);
    //get All Rating
    List<Rating> getAllRating();
    //get All By UserId
    List<Rating> getAllRatingByUserId(String userId);
    //get All By HotelId
    List<Rating> getAllRatingByHotelId(String hotelId);
}

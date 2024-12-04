package com.ravi.Rating_Service.repositories;

import com.ravi.Rating_Service.entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface RatingRepository extends MongoRepository<Rating,String> {
    List<Rating> findRatingByUserId(String userId);
    List<Rating> findRatingByHotelId(String hotelId);
}

package com.ravi.Rating_Service.services.impl;

import com.ravi.Rating_Service.entities.Rating;
import com.ravi.Rating_Service.repositories.RatingRepository;
import com.ravi.Rating_Service.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ImplRatingService implements RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    @Override
    public Rating createRating(Rating rating) {
        return ratingRepository.save(rating);
    }

    @Override
    public List<Rating> getAllRating() {
        return ratingRepository.findAll();
    }

    @Override
    public List<Rating> getAllRatingByUserId(String userId) {
        return ratingRepository.findRatingByUserId(userId);
    }

    @Override
    public List<Rating> getAllRatingByHotelId(String hotelId) {
        return ratingRepository.findRatingByHotelId(hotelId);
    }
}

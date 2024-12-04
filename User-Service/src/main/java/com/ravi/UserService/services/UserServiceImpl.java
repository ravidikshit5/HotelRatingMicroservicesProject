package com.ravi.UserService.services;

import com.ravi.UserService.entities.Hotel;
import com.ravi.UserService.entities.Rating;
import com.ravi.UserService.entities.User;
import com.ravi.UserService.exceptions.ResourceNotFoundException;
import com.ravi.UserService.repositories.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServ {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    //private final Logger logger = (Logger) LoggerFactory.getLogger(UserServiceImpl.class);



    @Override
    public User saveUser(User user) {
     String randomUserId =  UUID.randomUUID().toString();
     user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUser() {
       List<User> user = userRepository.findAll();
        for(User u:user){
            String userId=u.getUserId();
            String url = "http://localhost:8083/rating/userId/"+userId;
       ArrayList userRating = restTemplate.getForObject(url,ArrayList.class);
       logger.info("{}",userRating);
       u.setRatings(userRating);
        }
        return user;
    }

    @Override
    public User getUser(String userId) {
        //This will give the user of that Id in same database MySql
        User user =  userRepository.findById(userId).orElseThrow(()->new ResourceNotFoundException());
        String url = "http://localhost:8083/rating/userId/" + userId;

     List<Rating> ratingsOfUsers =    restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Rating>>() {}).getBody();
     logger.info("{}",ratingsOfUsers);
     user.setRatings(ratingsOfUsers);
     //List<Rating> ratingList = ratingsOfUsers;
     for(Rating r:ratingsOfUsers){
         String hotelId = r.getHotelId();
         String url1 = "http://localhost:8081/hotel/"+hotelId;
         Hotel hotelInfo = restTemplate.getForObject(url1, Hotel.class);
         r.setHotel(hotelInfo);
     }

        return user;

    }
}

package com.ravi.Hostel_Service.repositories;

import com.ravi.Hostel_Service.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository extends JpaRepository<Hotel,String> {

}

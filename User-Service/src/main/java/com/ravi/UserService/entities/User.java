package com.ravi.UserService.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "micro_users")
public class User {

   @Id
   private String userId;
   private String name;
   private String email;
   private String about;
   @Transient
   private List<Rating> ratings = new ArrayList<>();
}

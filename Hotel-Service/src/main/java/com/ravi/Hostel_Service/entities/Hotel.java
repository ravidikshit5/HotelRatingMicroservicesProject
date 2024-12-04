package com.ravi.Hostel_Service.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "hotels")
public class Hotel {
    @Id
    private String id;
    private String name;
    private String location;
    private String about;
}

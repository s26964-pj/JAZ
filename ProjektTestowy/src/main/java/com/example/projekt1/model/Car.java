package com.example.projekt1.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import org.hibernate.annotations.UuidGenerator;

import java.util.UUID;

@Entity
@Data
public class Car {

    @Id
    @UuidGenerator
    private UUID id;
    private String name;
    private int yearOfProduction;
    private String history;
}

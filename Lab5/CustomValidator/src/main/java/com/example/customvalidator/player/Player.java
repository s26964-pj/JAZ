package com.example.customvalidator.player;

import com.example.customvalidator.player.validation.Dictionary;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
public class Player {
    @Id
    @GeneratedValue()
    private UUID id;

    private String firstName;
    private String lastName;
    private int age;
    private int growth;

    @Dictionary(tableName = "position")
    private String position;
}
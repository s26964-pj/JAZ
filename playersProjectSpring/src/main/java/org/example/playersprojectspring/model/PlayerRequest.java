package org.example.playersprojectspring.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import org.example.playersprojectspring.enums.playerPosition;

@Data
public class PlayerRequest {

    private String firstName;
    private String lastName;
    private int age;
    private int growth;
    private playerPosition position;
}
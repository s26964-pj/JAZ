package org.example.playersprojectspring.model;

import jakarta.persistence.*;
import lombok.Data;
import org.example.playersprojectspring.enums.playerPosition;

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

    @Enumerated
    private playerPosition position;

}

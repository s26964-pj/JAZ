package org.example.playersprojectspring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.playersprojectspring.enums.playerPosition;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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

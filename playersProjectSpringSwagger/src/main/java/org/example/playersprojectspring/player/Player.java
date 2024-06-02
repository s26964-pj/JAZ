package org.example.playersprojectspring.player;

import jakarta.persistence.*;
import lombok.Data;
import org.example.playersprojectspring.player.position.PlayerPosition;

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
    private PlayerPosition position;
}

package org.example.playersprojectspring.player;

import jakarta.persistence.*;
import lombok.Data;
import org.example.playersprojectspring.player.position.playerPosition;
import org.example.playersprojectspring.team.Team;

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

    @ManyToOne
    private Team team;
}

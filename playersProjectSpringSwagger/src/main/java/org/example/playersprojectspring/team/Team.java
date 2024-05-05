package org.example.playersprojectspring.team;

import jakarta.persistence.*;
import lombok.Data;
import org.example.playersprojectspring.player.Player;

import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue()
    private UUID id;
    private String name;
    @OneToMany
    private List<Player> listPlayer;
}

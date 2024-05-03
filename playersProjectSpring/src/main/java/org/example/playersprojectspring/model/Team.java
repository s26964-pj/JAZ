package org.example.playersprojectspring.model;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;
import java.util.UUID;

@Data
@Entity
public class Team {
    @Id
    @GeneratedValue()
    private UUID id;

    private String name;
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> playerList;
}

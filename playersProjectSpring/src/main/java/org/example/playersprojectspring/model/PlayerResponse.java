package org.example.playersprojectspring.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.playersprojectspring.enums.playerPosition;

@Data
public class PlayerResponse {
    private String firstName;
    private String lastName;
    private playerPosition position;
    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;
}

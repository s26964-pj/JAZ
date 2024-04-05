package org.example.playersprojectspring.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.example.playersprojectspring.enums.playerPosition;

@Data
public class PlayerResponse {
    private String firstName;
    private String lastName;
    private playerPosition position;
}

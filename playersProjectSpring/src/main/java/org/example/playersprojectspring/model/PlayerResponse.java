package org.example.playersprojectspring.model;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.playersprojectspring.enums.playerPosition;

@Data
@NoArgsConstructor
public class PlayerResponse {
    private String firstName;
    private String lastName;
    private playerPosition position;
}

package org.example.playersprojectspring.team;

import jakarta.persistence.EntityNotFoundException;
import org.example.playersprojectspring.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TeamRepository extends JpaRepository<Team, UUID> {
    default Team getOrThrowException(UUID id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("Team not found"));
    }
}

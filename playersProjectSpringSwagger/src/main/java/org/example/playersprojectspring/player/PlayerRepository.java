package org.example.playersprojectspring.player;

import jakarta.persistence.EntityNotFoundException;
import org.example.playersprojectspring.player.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    default Player getOrThrowException(UUID id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }
}

package org.example.playersprojectspring.repository;

import jakarta.persistence.EntityNotFoundException;
import org.example.playersprojectspring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
    default Player getOrThrowException(UUID id) {
        return findById(id).orElseThrow(() -> new EntityNotFoundException("Player not found"));
    }
}

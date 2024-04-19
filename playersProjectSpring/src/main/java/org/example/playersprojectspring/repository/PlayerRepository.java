package org.example.playersprojectspring.repository;

import org.example.playersprojectspring.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
@Repository
public interface PlayerRepository extends JpaRepository<Player, UUID> {
}

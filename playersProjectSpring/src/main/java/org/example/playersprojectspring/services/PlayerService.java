package org.example.playersprojectspring.services;

import org.example.playersprojectspring.mapper.PlayerMapper;
import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final PlayerMapper mapper;

    public PlayerService(PlayerRepository playerRepository, PlayerMapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }

    public Player createPlayer(PlayerRequest playerRequest) {
        Player entity = mapper.toEntity(playerRequest);
        return playerRepository.save(entity);
    }

    public Player getPlayerById(UUID id) {
        return playerRepository.getOrThrowException(id);
    }

    public Player updatePlayer(UUID id, PlayerRequest player) {
        Player existingPlayer = playerRepository.getOrThrowException(id);

        Player updatedPlayer = mapper.toEntity(player);
        updatedPlayer.setId(existingPlayer.getId());

        return playerRepository.save(updatedPlayer);
    }

    public void deletePlayer(UUID id) {
        Player player = playerRepository.getOrThrowException(id);
        playerRepository.delete(player);
    }
}

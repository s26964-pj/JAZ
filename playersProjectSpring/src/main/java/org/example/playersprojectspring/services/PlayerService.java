package org.example.playersprojectspring.services;

import org.example.playersprojectspring.mapper.PlayerMapper;
import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.model.PlayerResponse;
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

    public PlayerResponse getPlayerById(UUID id) {
        Player player = playerRepository.getOrThrowException(id);
        PlayerResponse playerResponse = mapper.toResponse(player);
        return playerResponse;
    }

    public List<PlayerResponse> getAllPlayers() {
        return playerRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Player updatePlayer(UUID id, PlayerRequest playerRequest) {
        Player existingPlayer = playerRepository.getOrThrowException(id);

        Player updatedPlayer = mapper.toEntity(playerRequest);
        updatedPlayer.setId(existingPlayer.getId());
        return playerRepository.save(updatedPlayer);
    }

    public void deletePlayer(UUID id) {
        Player player = playerRepository.getOrThrowException(id);
        playerRepository.delete(player);
    }
}

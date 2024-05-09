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

    public PlayerResponse createPlayer(PlayerRequest playerRequest) {
        Player entity = mapper.toEntity(playerRequest);
        playerRepository.save(entity);
        return mapper.toResponse(entity);
    }

    public PlayerResponse getPlayerById(UUID id) {
        Player player = playerRepository.getOrThrowException(id);
        return mapper.toResponse(player);
    }

    public List<PlayerResponse> getAllPlayers() {
        return playerRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public PlayerResponse updatePlayer(UUID id, PlayerRequest playerRequest) {
        Player existingPlayer = playerRepository.getOrThrowException(id);

        Player updatedPlayer = mapper.toEntity(playerRequest);
        updatedPlayer.setId(existingPlayer.getId());
        playerRepository.save(updatedPlayer);

        return mapper.toResponse(updatedPlayer);
    }

    public void deletePlayer(UUID id) {
        Player player = playerRepository.getOrThrowException(id);
        playerRepository.delete(player);
    }
}

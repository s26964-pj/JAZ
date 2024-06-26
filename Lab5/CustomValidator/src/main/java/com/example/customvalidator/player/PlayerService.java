package com.example.customvalidator.player;

import com.example.customvalidator.Mapper;
import jakarta.transaction.Transactional;
import org.openapitools.model.PlayerRequest;
import org.openapitools.model.PlayerResponse;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final Mapper mapper;

    public PlayerService(PlayerRepository playerRepository, Mapper mapper) {
        this.playerRepository = playerRepository;
        this.mapper = mapper;
    }
    @Transactional
    public PlayerResponse addPlayer(PlayerRequest player) {
        Player entity = mapper.toEntity(player);
        playerRepository.save(entity);
        return mapper.toResponse(entity);
    }

    public List<PlayerResponse> getAllPlayers() {
        return playerRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public PlayerResponse getPlayerById(UUID id) {
        Player player = playerRepository.getReferenceById(id);
        return mapper.toResponse(player);
    }

    public PlayerResponse updatePlayer(UUID id, PlayerRequest player) {
        Player existingPlayer = playerRepository.getReferenceById(id);

        Player updatedPlayer = mapper.toEntity(player);
        updatedPlayer.setId(existingPlayer.getId());

        playerRepository.save(updatedPlayer);
        return mapper.toResponse(updatedPlayer);
    }

    public void deletePlayer(UUID id) {
        Player player = playerRepository.getReferenceById(id);
        playerRepository.delete(player);
    }
}

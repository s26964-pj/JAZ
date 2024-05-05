package org.example.playersprojectspring.player;

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

    public Player addPlayer(Player player) {
        Player entity = mapper.toEntity(player);
        return playerRepository.save(entity);
    }

    public List<Player> getAllPlayers() {
        return playerRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Player getPlayerById(UUID id) {
        return playerRepository.getOrThrowException(id);
    }

    public Player updatePlayer(UUID id, Player player) {
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

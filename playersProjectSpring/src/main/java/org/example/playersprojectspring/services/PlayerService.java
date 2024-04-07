package org.example.playersprojectspring.services;

import org.example.playersprojectspring.mapper.PlayerMapper;
import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.model.PlayerResponse;
import org.example.playersprojectspring.repository.PlayerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Player addPlayer(PlayerRequest playerRequest) {
        Player entity = mapper.toEntity(playerRequest);
        return playerRepository.save(entity);
    }

    public List<PlayerResponse> getAllPlayers() {
        return playerRepository
                .findAll()
                .stream()
                .map(mapper::toResponse)
                .collect(Collectors.toList());
    }

    public Optional<Player> getPlayerById(UUID id) {
        return playerRepository.findById(id);
    }

    public Player updatePlayer(UUID id, PlayerRequest playerRequest) {
        Player player = playerRepository.getReferenceById(id);
        Player mapped = mapper.toUpdate(player);
        Player saved = playerRepository.save(mapped);
        return saved;
    }

    public void deletePlayer(UUID id) {
        playerRepository.deleteById(id);
        System.out.println("Sukces");
    }
}

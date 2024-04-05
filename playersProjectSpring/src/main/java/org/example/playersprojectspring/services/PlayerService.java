package org.example.playersprojectspring.services;

import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }
    public Player addPlayer(PlayerRequest playerRequest) {
        Player player = new Player();
        player.setFirstName(playerRequest.getFirstName());
        player.setLastName(playerRequest.getLastName());
        player.setAge(playerRequest.getAge());
        player.setGrowth(playerRequest.getGrowth());
        player.setPosition(playerRequest.getPosition());
        return playerRepository.save(player);
    }

    public List<Player> getAllPlayers() {
        return playerRepository.findAll();
    }

    public Optional<Player> getPlayerById(UUID id) {
        return playerRepository.findById(id);
    }

    public Player updatePlayer(UUID id, PlayerRequest playerRequest) {
        return playerRepository.findById(id).map(player -> {
            player.setFirstName(playerRequest.getFirstName());
            player.setLastName(playerRequest.getLastName());
            player.setAge(playerRequest.getAge());
            player.setGrowth(playerRequest.getGrowth());
            player.setPosition(playerRequest.getPosition());
            return playerRepository.save(player);
        }).orElseThrow(() -> new PlayerNotFoundException("Player not found with id: " + id));
    }

    public void deletePlayer(UUID id) {
        playerRepository.deleteById(id);
        System.out.println("Sukces");
    }
}

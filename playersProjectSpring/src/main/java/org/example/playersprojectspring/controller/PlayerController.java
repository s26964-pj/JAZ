package org.example.playersprojectspring.controller;

import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.services.PlayerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.getAllPlayers();
    }

    @GetMapping("/{id}")
    public Player getPlayerById(@PathVariable UUID id) {
        return playerService.getPlayerById(id).orElse(null);
    }

    @PostMapping
    public Player addPlayer(@RequestBody PlayerRequest playerRequest) {
        return playerService.addPlayer(playerRequest);
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable UUID id, @RequestBody PlayerRequest playerRequest) {
        return playerService.updatePlayer(id, playerRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable UUID id) {
        playerService.deletePlayer(id);
    }
}

package org.example.playersprojectspring.controller;

import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.model.PlayerResponse;
import org.example.playersprojectspring.services.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/players")
public class PlayerController {

    private final PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @PostMapping
    public Player createPlayer(@RequestBody PlayerRequest playerRequest) {
        return playerService.createPlayer(playerRequest);
    }

    @GetMapping("/{id}")
    public PlayerResponse getPlayerById(@PathVariable("id") UUID id) {
        Player player = playerService.getPlayerById(id);
        return new PlayerResponse(player.getFirstName(), player.getLastName(), player.getPosition());
    }

    @PutMapping("/{id}")
    public Player updatePlayer(@PathVariable("id") UUID id, @RequestBody PlayerRequest playerRequest) {
        return playerService.updatePlayer(id, playerRequest);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable("id") String id) {
        playerService.deletePlayer(id);
    }
}

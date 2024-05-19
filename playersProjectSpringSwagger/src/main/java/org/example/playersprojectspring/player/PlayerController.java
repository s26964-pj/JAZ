package org.example.playersprojectspring.player;

import org.openapitools.api.PlayersApi;
import org.openapitools.model.PlayerRequest;
import org.openapitools.model.PlayerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
public class PlayerController implements PlayersApi {


    private final PlayerService playerService;

    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    @Override
    public ResponseEntity<PlayerResponse> addPlayer(PlayerRequest playerRequest) {
        return ResponseEntity.ok(playerService.addPlayer(playerRequest));
    }

    @Override
    public ResponseEntity<Void> deletePlayer(UUID id) {
        playerService.deletePlayer(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return ResponseEntity.ok(playerService.getAllPlayers());
    }

    @Override
    public ResponseEntity<PlayerResponse> getPlayerById(UUID id) {
        return ResponseEntity.ok(playerService.getPlayerById(id));
    }

    @Override
    public ResponseEntity<PlayerResponse> updatePlayer(UUID id, PlayerRequest playerRequest) {
        return ResponseEntity.ok(playerService.updatePlayer(id, playerRequest));
    }
}

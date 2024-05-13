package org.example.playersprojectspring.player;

import lombok.RequiredArgsConstructor;
import org.openapitools.api.PlayersApi;
import org.openapitools.model.PlayerRequest;
import org.openapitools.model.PlayerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class PlayerController implements PlayersApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return PlayersApi.super.getRequest();
    }

    @Override
    public ResponseEntity<PlayerResponse> addPlayer(PlayerRequest playerRequest) {
        return PlayersApi.super.addPlayer(playerRequest);
    }

    @Override
    public ResponseEntity<Void> deletePlayer(UUID id) {
        return PlayersApi.super.deletePlayer(id);
    }

    @Override
    public ResponseEntity<List<PlayerResponse>> getAllPlayers() {
        return PlayersApi.super.getAllPlayers();
    }

    @Override
    public ResponseEntity<PlayerResponse> getPlayerById(UUID id) {
        return PlayersApi.super.getPlayerById(id);
    }

    @Override
    public ResponseEntity<PlayerResponse> updatePlayer(UUID id, PlayerRequest playerRequest) {
        return PlayersApi.super.updatePlayer(id, playerRequest);
    }
}

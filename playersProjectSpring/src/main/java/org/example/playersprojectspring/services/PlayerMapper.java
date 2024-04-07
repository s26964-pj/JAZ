package org.example.playersprojectspring.services;

import org.example.playersprojectspring.model.Player;
import org.example.playersprojectspring.model.PlayerRequest;
import org.example.playersprojectspring.model.PlayerResponse;
import org.mapstruct.*;

import java.util.List;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlayerMapper {
    @Mapping(target = "id", ignore = true)
    Player toEntity(PlayerRequest request);
    PlayerResponse toResponse(Player player);
    List<PlayerResponse> toResponse(List<Player> playerList);
    Player toUpdate(Player player);
}

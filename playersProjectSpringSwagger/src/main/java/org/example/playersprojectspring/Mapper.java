package org.example.playersprojectspring;

import org.example.playersprojectspring.player.Player;
import org.example.playersprojectspring.team.Team;
import org.mapstruct.*;
import org.openapitools.model.PlayerRequest;
import org.openapitools.model.PlayerResponse;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Mapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "team", ignore = true)
    Player toEntity(PlayerRequest PlayerRequest);
    PlayerResponse toResponse(Player player);

    @Mapping(target = "id", ignore = true)
    Team toEntity(Team team);
}
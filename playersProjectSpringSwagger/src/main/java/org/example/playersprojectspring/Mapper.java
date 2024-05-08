package org.example.playersprojectspring;

import org.example.playersprojectspring.player.Player;
import org.example.playersprojectspring.team.Team;
import org.mapstruct.*;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Mapper {
    @Mapping(target = "id", ignore = true)
    Player toEntity(Player request);

    @Mapping(target = "id", ignore = true)
    Team toEntity(Team team);
}
package org.example.playersprojectspring.player;

import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface PlayerMapper {
    @Mapping(target = "id", ignore = true)
    Player toEntity(Player request);

    Player toResponse(Player player);

    Player toUpdate(Player player);
}
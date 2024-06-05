package com.example.customvalidator;

import com.example.customvalidator.player.Player;
import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.openapitools.model.PlayerRequest;
import org.openapitools.model.PlayerResponse;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
public interface Mapper {
    @Mapping(target = "id", ignore = true)
    Player toEntity(PlayerRequest PlayerRequest);
    PlayerResponse toResponse(Player player);
}
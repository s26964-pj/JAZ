package org.example.playersprojectspring.team;

import org.mapstruct.Builder;
import org.mapstruct.Mapping;
import org.mapstruct.NullValueCheckStrategy;
import org.mapstruct.ReportingPolicy;

@org.mapstruct.Mapper(unmappedTargetPolicy = ReportingPolicy.ERROR,
        componentModel = "spring",
        builder = @Builder(disableBuilder = true),
        nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface TeamMapper {
    @Mapping(target = "id", ignore = true)
    Team toEntity(Team team);

    Team toResponse(Team team);

    Team toUpdate(Team team);
}

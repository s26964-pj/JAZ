package org.example.playersprojectspring.team;

import org.example.playersprojectspring.Mapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final Mapper mapper;

    public TeamService(TeamRepository teamRepository, Mapper mapper) {
        this.teamRepository = teamRepository;
        this.mapper = mapper;
    }

    public Team addTeam(Team team) {
        Team entity = mapper.toEntity(team);
        return teamRepository.save(entity);
    }

    public List<Team> getAllTeams() {
        return teamRepository
                .findAll()
                .stream()
                .map(mapper::toEntity)
                .collect(Collectors.toList());
    }

    public Team getTeamById(UUID id) {
        return teamRepository.getOrThrowException(id);
    }

    public Team updateTeam(UUID id, Team team) {
        Team existingTeam = teamRepository.getOrThrowException(id);

        Team updatedTeam = mapper.toEntity(team);
        updatedTeam.setId(existingTeam.getId());

        return teamRepository.save(updatedTeam);
    }

    public void deleteTeam(UUID id) {
        Team team = teamRepository.getOrThrowException(id);
        teamRepository.delete(team);
    }
}

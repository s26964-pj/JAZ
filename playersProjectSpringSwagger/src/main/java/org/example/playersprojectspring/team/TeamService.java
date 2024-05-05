package org.example.playersprojectspring.team;

import org.example.playersprojectspring.team.Team;
import org.example.playersprojectspring.team.TeamRepository;
import org.example.playersprojectspring.team.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper mapper;

    public TeamService(TeamRepository teamRepository, TeamMapper mapper) {
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
                .map(mapper::toResponse)
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

package com.dojo.solid.missions;

import com.dojo.solid.agents.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryMissionsRepository implements MissionsRepository {
    private List<Mission> missions = new ArrayList<>();

    @Override
    public boolean add(Mission mission) {
        missions.add(mission);
        return true;
    }

    @Override
    public List<Mission> findAll() {
        return new ArrayList<>(missions);
    }

    @Override
    public Optional<Mission> findById(String missionId) {
        return missions.stream()
                .filter(m -> missionId.equals(m.getId()))
                .findFirst();
    }

    @Override
    public List<Mission> findByAgent(String agentId) {
        return missions.stream()
                .filter(m -> {
                    Agent agent = m.getAgent();
                    return agent != null && agentId.equals(agent.getId());
                })
                .collect(Collectors.toList());
    }
}

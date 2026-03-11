package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.agents.Agent;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class InMemoryBackedMissionsRepository implements BackedMissionsRepository {
    private List<BackedMission> missions = new ArrayList<>();

    @Override
    public boolean add(BackedMission mission) {
        missions.add(mission);
        return true;
    }

    @Override
    public List<BackedMission> findAll() {
        return new ArrayList<>(missions);
    }

    @Override
    public Optional<BackedMission> findById(String missionId) {
        return missions.stream()
                .filter(m -> missionId.equals(m.getId()))
                .findFirst();
    }

    @Override
    public List<BackedMission> findByAgent(String agentId) {
        return missions.stream()
                .filter(m -> {
                    Agent agent = m.getAgent();
                    return (agent != null && agentId.equals(agent.getId()))
                            || BackedMissionsHelpers.isAgentInBackup(agentId, m);
                })
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeBackup(String missionId, String backupId) {
        Optional<BackedMission> missionOpt = findById(missionId);
        if (!missionOpt.isPresent() || missionOpt.get().getBackup() == null) {
            return false;
        }

        BackedMission mission = missionOpt.get();
        Optional<Agent> backupAgent = mission.getBackup().stream()
                .filter(a -> a != null && backupId.equals(a.getId()))
                .findFirst();

        if (!backupAgent.isPresent()) {
            return false;
        }

        List<Agent> updatedBackup = mission.getBackup().stream()
                .filter(a -> !backupId.equals(a.getId()))
                .collect(Collectors.toList());
        mission.setBackup(updatedBackup);
        return true;
    }
}

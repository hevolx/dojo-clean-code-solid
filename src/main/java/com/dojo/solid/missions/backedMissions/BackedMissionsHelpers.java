package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.agents.Agent;

public class BackedMissionsHelpers {
    public static boolean isAgentInBackup(String agentId, BackedMission mission) {
        if (agentId == null || mission == null
                || mission.getBackup() == null || mission.getBackup().isEmpty()) {
            return false;
        }
        return mission.getBackup().stream()
                .anyMatch(backup -> backup != null && agentId.equals(backup.getId()));
    }
}

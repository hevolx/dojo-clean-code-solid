package com.dojo.solid.missions;

import com.dojo.solid.agents.AgentPolicies;

import java.util.List;

public class MissionPolicies {
    public static boolean isMissionValid(Mission mission) {
        return mission != null
                && mission.getId() != null
                && !mission.getId().isEmpty()
                && AgentPolicies.isAgentValid(mission.getAgent())
                && mission.getStartDate() != 0;
    }

    public static boolean hasAlreadyAMissionWithinThisPeriod(List<Mission> agentMissions, Mission newMission) {
        return MissionsHelpers.getMissionWithinPeriod(
                agentMissions,
                newMission.getStartDate(),
                newMission.getEndDate()
        ).isPresent();
    }
}

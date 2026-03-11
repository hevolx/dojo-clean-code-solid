package com.dojo.solid.missions;

import com.dojo.solid.missions.errors.InvalidMission;
import com.dojo.solid.missions.errors.MissionConflict;

import java.util.List;
import java.util.Optional;

public class MissionsService {
    private MissionsRepository missionsRepository;

    public MissionsService(MissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    public boolean addMission(Mission mission) {
        if (!MissionPolicies.isMissionValid(mission)) {
            throw new InvalidMission(mission);
        }

        if (MissionPolicies.hasAlreadyAMissionWithinThisPeriod(
                getAgentMissions(mission.getAgent().getId()),
                mission
        )) {
            throw new MissionConflict(mission);
        }

        return missionsRepository.add(mission);
    }

    public List<Mission> getAllMissions() {
        return missionsRepository.findAll();
    }

    public Optional<Mission> getMissionInformation(String missionId) {
        return missionsRepository.findById(missionId);
    }

    public List<Mission> getAgentMissions(String agentId) {
        return missionsRepository.findByAgent(agentId);
    }

    public Optional<Mission> getAgentCurrentMission(String agentId) {
        long currentDate = System.currentTimeMillis();
        return MissionsHelpers.getMissionWithinPeriod(getAgentMissions(agentId), currentDate, currentDate);
    }
}

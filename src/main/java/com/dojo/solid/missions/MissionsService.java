package com.dojo.solid.missions;

import com.dojo.solid.agents.AgentPolicies;
import com.dojo.solid.missions.errors.InvalidMission;
import com.dojo.solid.missions.errors.MissionConflict;

import java.util.List;
import java.util.Optional;

public class MissionsService {
    // TODO (Exercise 1 - SRP): MissionsService depends on a concrete implementation.
    //  It should depend on the MissionsRepository interface instead.
    private InMemoryMissionsRepository missionsRepository;

    public MissionsService(InMemoryMissionsRepository missionsRepository) {
        this.missionsRepository = missionsRepository;
    }

    public boolean addMission(Mission mission) {
        // TODO (Exercise 1 - SRP): This method has too many responsibilities.
        //  The validation logic (isAgentValid, getMissionWithinPeriod) should be
        //  extracted into a separate MissionPolicies class.
        if (mission == null
                || mission.getId() == null
                || mission.getId().isEmpty()
                || !AgentPolicies.isAgentValid(mission.getAgent())
                || mission.getStartDate() == 0) {
            throw new InvalidMission(mission);
        }

        if (MissionsHelpers.getMissionWithinPeriod(
                getAgentMissions(mission.getAgent().getId()),
                mission.getStartDate(),
                mission.getEndDate()
        ).isPresent()) {
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

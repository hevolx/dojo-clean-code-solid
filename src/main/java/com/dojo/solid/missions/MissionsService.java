package com.dojo.solid.missions;

import com.dojo.solid.missions.backedMissions.BackedMission;
import com.dojo.solid.missions.backedMissions.BackedMissionsHelpers;
import com.dojo.solid.missions.backedMissions.BackedMissionsRepository;
import com.dojo.solid.missions.errors.InvalidMission;
import com.dojo.solid.missions.errors.MissionConflict;

import java.util.List;
import java.util.Optional;

public class MissionsService {
    private MissionsRepository missionsRepository;
    // TODO (Exercise 2 - OCP): MissionsService has been modified to handle backed missions.
    //  All BackedMission-specific logic should be moved to a new BackedMissionsService
    //  that extends MissionsService, leaving this class untouched.
    private BackedMissionsRepository backedMissionsRepository;

    public MissionsService(MissionsRepository missionsRepository,
                           BackedMissionsRepository backedMissionsRepository) {
        this.missionsRepository = missionsRepository;
        this.backedMissionsRepository = backedMissionsRepository;
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

    // TODO (Exercise 2 - OCP): The following methods do not belong in MissionsService.
    //  They are BackedMission-specific and should live in a BackedMissionsService subclass.

    public List<Mission> getAllBackedMissions() {
        return new java.util.ArrayList<>(backedMissionsRepository.findAll());
    }

    public List<Mission> getAgentBackedMissions(String agentId) {
        return new java.util.ArrayList<>(backedMissionsRepository.findByAgent(agentId));
    }

    public Optional<BackedMission> getBackedMissionInformation(String missionId) {
        return backedMissionsRepository.findById(missionId);
    }

    public boolean removeBackupFromMission(BackedMission mission, String backupId) {
        if (!BackedMissionsHelpers.isAgentInBackup(backupId, mission)) {
            return false;
        }
        return backedMissionsRepository.removeBackup(mission.getId(), backupId);
    }
}

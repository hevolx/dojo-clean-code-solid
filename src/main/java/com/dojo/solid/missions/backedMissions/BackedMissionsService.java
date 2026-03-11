package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.missions.Mission;
import com.dojo.solid.missions.MissionsService;
import com.dojo.solid.missions.errors.InvalidMission;

import java.util.Optional;

public class BackedMissionsService extends MissionsService {
    private BackedMissionsRepository backedMissionsRepository;

    public BackedMissionsService(BackedMissionsRepository backedMissionsRepository) {
        super(backedMissionsRepository);
        this.backedMissionsRepository = backedMissionsRepository;
    }

    // TODO (Exercise 3 - LSP): This method overrides addMission() from MissionsService and adds
    //  a stronger precondition: the mission must have at least one backup agent.
    //  This violates LSP because callers of MissionsService cannot substitute BackedMissionsService
    //  without knowing about this additional constraint.
    //  Fix: rename this method (e.g. addBackedMission) so it does not override the parent's contract.
    @Override
    public boolean addMission(Mission mission) {
        if (!BackedMissionsHelpers.hasBackup((BackedMission) mission)) {
            throw new InvalidMission(mission);
        }
        return super.addMission(mission);
    }

    public Optional<BackedMission> getBackedMissionInformation(String missionId) {
        return backedMissionsRepository.findBackedById(missionId);
    }

    public boolean removeBackupFromMission(BackedMission mission, String backupId) {
        if (!BackedMissionsHelpers.isAgentInBackup(backupId, mission)) {
            return false;
        }
        return backedMissionsRepository.removeBackup(mission.getId(), backupId);
    }
}

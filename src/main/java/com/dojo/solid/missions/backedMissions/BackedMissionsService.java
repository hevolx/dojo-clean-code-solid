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

    // addBackedMission is a NEW method, not an override of addMission.
    // This respects LSP: BackedMissionsService can still be substituted for MissionsService
    // because addMission() behavior is unchanged.
    public boolean addBackedMission(BackedMission mission) {
        if (!BackedMissionsHelpers.hasBackup(mission)) {
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

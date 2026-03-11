package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.missions.MissionsService;

import java.util.Optional;

public class BackedMissionsService extends MissionsService {
    private BackedMissionsRepository backedMissionsRepository;

    public BackedMissionsService(BackedMissionsRepository backedMissionsRepository) {
        super(backedMissionsRepository);
        this.backedMissionsRepository = backedMissionsRepository;
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

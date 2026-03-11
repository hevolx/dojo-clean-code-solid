package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.missions.MissionsRepository;

import java.util.Optional;

public interface BackedMissionsRepository extends MissionsRepository {
    Optional<BackedMission> findBackedById(String id);
    boolean removeBackup(String missionId, String backupId);
}

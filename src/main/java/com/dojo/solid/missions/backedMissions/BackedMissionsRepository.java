package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.standards.repositories.Repository;

import java.util.List;

public interface BackedMissionsRepository extends Repository<BackedMission, String> {
    List<BackedMission> findByAgent(String agentId);
    boolean removeBackup(String missionId, String backupId);
}

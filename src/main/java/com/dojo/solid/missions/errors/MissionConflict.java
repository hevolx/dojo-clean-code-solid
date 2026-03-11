package com.dojo.solid.missions.errors;

import com.dojo.solid.missions.Mission;

public class MissionConflict extends RuntimeException {
    public MissionConflict(Mission mission) {
        super("Mission " + missionId(mission) + " cannot be created,"
                + " another mission is already set within the period.");
    }

    private static String missionId(Mission mission) {
        return (mission != null && mission.getId() != null) ? mission.getId() : "N/A";
    }
}

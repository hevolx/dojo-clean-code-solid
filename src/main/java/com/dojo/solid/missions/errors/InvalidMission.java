package com.dojo.solid.missions.errors;

import com.dojo.solid.missions.Mission;

public class InvalidMission extends RuntimeException {
    public InvalidMission(Mission mission) {
        super("Mission " + missionId(mission) + " is invalid");
    }

    private static String missionId(Mission mission) {
        return (mission != null && mission.getId() != null) ? mission.getId() : "N/A";
    }
}

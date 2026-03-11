package com.dojo.solid.missions;

import java.util.List;
import java.util.Optional;

public class MissionsHelpers {
    public static boolean isMissionWithinPeriod(Mission mission, long startDate, Long endDate) {
        Long missionEndDate = mission.getEndDate();
        return mission.getStartDate() <= startDate
                && (endDate == null || missionEndDate == null || missionEndDate > endDate);
    }

    public static Optional<Mission> getMissionWithinPeriod(List<Mission> missions, long startDate, Long endDate) {
        if (missions == null) {
            return Optional.empty();
        }
        return missions.stream()
                .filter(m -> isMissionWithinPeriod(m, startDate, endDate))
                .findFirst();
    }
}

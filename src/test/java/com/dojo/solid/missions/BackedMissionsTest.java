package com.dojo.solid.missions;

import com.dojo.solid.agents.Agent;
import com.dojo.solid.missions.backedMissions.BackedMission;
import com.dojo.solid.missions.backedMissions.BackedMissionsRepository;
import com.dojo.solid.missions.backedMissions.InMemoryBackedMissionsRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class BackedMissionsTest {
    private BackedMissionsRepository backedMissionsRepository;
    private MissionsService backedMissionsService;

    private List<BackedMission> backedMissions;
    private Agent solidSnake;
    private Agent merylSilverburgh;
    private BackedMission shadowMosesMission;

    @BeforeEach
    void setUp() {
        solidSnake = new Agent("solid-snake");
        merylSilverburgh = new Agent("meryl-silverburgh");
        shadowMosesMission = new BackedMission(
                "shadow-moses-island",
                "Shadow Moses Island",
                solidSnake,
                new ArrayList<>(Arrays.asList(merylSilverburgh))
        );

        backedMissions = new ArrayList<>();
        backedMissions.add(shadowMosesMission);

        backedMissionsRepository = new InMemoryBackedMissionsRepository();
        for (BackedMission mission : backedMissions) {
            backedMissionsRepository.add(mission);
        }
        backedMissionsService = new MissionsService(new InMemoryMissionsRepository(), backedMissionsRepository);
    }

    @Test
    void shouldProvideListOfAllBackedMissions() {
        assertEquals(backedMissions, backedMissionsService.getAllBackedMissions());
    }

    @Test
    void shouldProvideMissionOfAgentWhenHeIsABackup() {
        assertTrue(backedMissionsService.getAgentBackedMissions("meryl-silverburgh")
                .contains(shadowMosesMission));
    }

    @Test
    void shouldBeAbleToRemoveABackupFromAMission() {
        backedMissionsService.removeBackupFromMission(shadowMosesMission, "meryl-silverburgh");

        Optional<BackedMission> missionInfo =
                backedMissionsService.getBackedMissionInformation("shadow-moses-island");

        assertTrue(missionInfo.isPresent());
        assertFalse(missionInfo.get().getBackup().contains(merylSilverburgh));
    }
}

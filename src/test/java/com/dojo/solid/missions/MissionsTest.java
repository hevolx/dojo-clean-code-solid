package com.dojo.solid.missions;

import com.dojo.solid.agents.Agent;
import com.dojo.solid.missions.backedMissions.InMemoryBackedMissionsRepository;
import com.dojo.solid.missions.errors.InvalidMission;
import com.dojo.solid.missions.errors.MissionConflict;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class MissionsTest {
    private InMemoryMissionsRepository missionsRepository;
    private MissionsService missionsService;

    private Agent solidSnake;
    private Agent nakedSnake;
    private Mission shadowMosesMission;
    private Mission zanzibarLandMission;
    private Mission dremuchijMission;
    private List<Mission> missions;

    @BeforeEach
    void setUp() {
        solidSnake = new Agent("solid-snake");
        nakedSnake = new Agent("naked-snake");

        shadowMosesMission = new Mission("shadow-moses-island", "Shadow Moses Island", solidSnake);
        shadowMosesMission.setEndDate(System.currentTimeMillis());

        zanzibarLandMission = new Mission("zanzibar-land", "Zanzibar Land", solidSnake);
        dremuchijMission = new Mission("dremuchij", "Dremuchij", nakedSnake);

        missions = new ArrayList<>();
        missions.add(shadowMosesMission);
        missions.add(zanzibarLandMission);

        missionsRepository = new InMemoryMissionsRepository();
        for (Mission mission : missions) {
            missionsRepository.add(mission);
        }
        missionsService = new MissionsService(missionsRepository, new InMemoryBackedMissionsRepository());
    }

    @Nested
    class Data {
        @Test
        void shouldProvideListOfAllMissions() {
            assertEquals(missions, missionsService.getAllMissions());
        }

        @Test
        void shouldProvideInformationOfSpecificMission() {
            assertEquals(Optional.of(shadowMosesMission),
                    missionsService.getMissionInformation("shadow-moses-island"));
        }

        @Test
        void shouldProvideListOfMissionsAssignedToAgent() {
            assertEquals(missions, missionsService.getAgentMissions("solid-snake"));
        }

        @Test
        void shouldProvideInformationAboutAgentsCurrentMission() {
            zanzibarLandMission.setStartDate(System.currentTimeMillis() - 10000);
            assertEquals(Optional.of(zanzibarLandMission),
                    missionsService.getAgentCurrentMission("solid-snake"));
        }

        @Test
        void shouldNotProvideAnyInformationIfAgentHasNoCurrentMission() {
            zanzibarLandMission.setEndDate(System.currentTimeMillis() - 1000);
            assertEquals(Optional.empty(), missionsService.getAgentCurrentMission("solid-snake"));
        }

        @Test
        void shouldCreateNewMissionWithProvidedInformation() {
            missionsService.addMission(dremuchijMission);
            List<Mission> expected = new ArrayList<>();
            expected.add(dremuchijMission);
            assertEquals(expected, missionsService.getAgentMissions("naked-snake"));
        }

        @Test
        void shouldNotBeAbleToCreateInvalidMission() {
            Mission tselinoyarskMission = new Mission("", "Tselinoyarsk", nakedSnake);
            assertThrows(InvalidMission.class, () -> missionsService.addMission(tselinoyarskMission));
        }

        @Test
        void shouldNotBeAbleToCreateMissionWithinSamePeriod() {
            Mission tselinoyarskMission = new Mission(
                    "tselinoyarsk", "Tselinoyarsk", nakedSnake, dremuchijMission.getStartDate());
            tselinoyarskMission.setEndDate(System.currentTimeMillis());

            missionsService.addMission(dremuchijMission);

            assertThrows(MissionConflict.class, () -> missionsService.addMission(tselinoyarskMission));
        }
    }
}

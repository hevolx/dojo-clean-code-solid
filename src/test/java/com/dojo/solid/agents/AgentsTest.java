package com.dojo.solid.agents;

import com.dojo.solid.agents.errors.InvalidAgent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class AgentsTest {
    private AgentsRepository agentsRepository;
    private AgentsService agentsService;
    private List<Agent> agents;

    @BeforeEach
    void setUp() {
        agents = new ArrayList<>();
        agents.add(new Agent("solid-snake"));
        agents.add(new Agent("meryl-silverburgh"));

        agentsRepository = new InMemoryAgentsRepository();
        for (Agent agent : agents) {
            agentsRepository.add(agent);
        }
        agentsService = new AgentsService(agentsRepository);
    }

    @Nested
    class Data {
        @Test
        void shouldProvideListOfAllAgents() {
            assertEquals(agents, agentsService.getAllAgents());
        }

        @Test
        void shouldProvideInformationAboutSpecificAgent() {
            assertEquals(Optional.of(agents.get(0)), agentsService.getAgentInformation("solid-snake"));
        }

        @Test
        void shouldNotProvideInformationForUnknownAgent() {
            assertEquals(Optional.empty(), agentsService.getAgentInformation("liquid-snake"));
        }

        @Test
        void shouldAddAgentToList() {
            Agent newAgent = new Agent("liquid-snake");
            agentsService.addAgent(newAgent);
            assertEquals(Optional.of(newAgent), agentsService.getAgentInformation(newAgent.getId()));
        }

        @Test
        void shouldNotBeAbleToCreateInvalidAgent() {
            Agent nakedSnake = new Agent("");
            assertThrows(InvalidAgent.class, () -> agentsService.addAgent(nakedSnake));
        }
    }
}

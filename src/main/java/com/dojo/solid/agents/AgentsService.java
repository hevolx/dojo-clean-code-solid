package com.dojo.solid.agents;

import com.dojo.solid.agents.errors.InvalidAgent;

import java.util.List;
import java.util.Optional;

public class AgentsService {
    // TODO (Exercise 5 - DIP): AgentsService depends on the concrete InMemoryAgentsRepository
    //  class instead of the AgentsRepository interface.
    //  High-level modules should not depend on low-level modules; both should depend on abstractions.
    //  Change the field type and constructor parameter to use the AgentsRepository interface.
    private InMemoryAgentsRepository agentsRepository;

    public AgentsService(InMemoryAgentsRepository agentsRepository) {
        this.agentsRepository = agentsRepository;
    }

    public boolean addAgent(Agent agent) {
        if (!AgentPolicies.isAgentValid(agent)) {
            throw new InvalidAgent(agent);
        }
        return agentsRepository.add(agent);
    }

    public List<Agent> getAllAgents() {
        return agentsRepository.findAll();
    }

    public Optional<Agent> getAgentInformation(String id) {
        return agentsRepository.findById(id);
    }
}

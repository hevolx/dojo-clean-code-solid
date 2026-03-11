package com.dojo.solid.agents;

import com.dojo.solid.agents.errors.InvalidAgent;

import java.util.List;
import java.util.Optional;

public class AgentsService {
    private AgentsRepository agentsRepository;

    public AgentsService(AgentsRepository agentsRepository) {
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

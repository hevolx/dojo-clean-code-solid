package com.dojo.solid.agents.errors;

import com.dojo.solid.agents.Agent;

public class InvalidAgent extends RuntimeException {
    public InvalidAgent(Agent agent) {
        super("Agent " + agentId(agent) + " is invalid");
    }

    private static String agentId(Agent agent) {
        return (agent != null && agent.getId() != null) ? agent.getId() : "N/A";
    }
}

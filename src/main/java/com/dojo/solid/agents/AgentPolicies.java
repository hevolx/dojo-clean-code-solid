package com.dojo.solid.agents;

public class AgentPolicies {
    public static boolean isAgentValid(Agent agent) {
        return agent != null && agent.getId() != null && !agent.getId().isEmpty();
    }
}

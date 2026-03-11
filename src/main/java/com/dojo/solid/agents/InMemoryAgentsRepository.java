package com.dojo.solid.agents;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InMemoryAgentsRepository implements AgentsRepository {
    private List<Agent> agents = new ArrayList<>();

    @Override
    public boolean add(Agent agent) {
        agents.add(agent);
        return true;
    }

    @Override
    public List<Agent> findAll() {
        return new ArrayList<>(agents);
    }

    @Override
    public Optional<Agent> findById(String id) {
        return agents.stream()
                .filter(a -> id.equals(a.getId()))
                .findFirst();
    }
}

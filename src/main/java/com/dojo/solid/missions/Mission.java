package com.dojo.solid.missions;

import com.dojo.solid.agents.Agent;

public class Mission {
    private String id;
    private String name;
    private Agent agent;
    private long startDate;
    private Long endDate;

    public Mission(String id, String name, Agent agent) {
        this.id = id;
        this.name = name;
        this.agent = agent;
        this.startDate = System.currentTimeMillis();
    }

    public Mission(String id, String name, Agent agent, long startDate) {
        this(id, name, agent);
        this.startDate = startDate;
    }

    public String getId() {
        return id;
    }

    public Agent getAgent() {
        return agent;
    }

    public long getStartDate() {
        return startDate;
    }

    public void setStartDate(long startDate) {
        this.startDate = startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public void setEndDate(long endDate) {
        this.endDate = endDate;
    }
}

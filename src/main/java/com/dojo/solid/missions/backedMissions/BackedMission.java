package com.dojo.solid.missions.backedMissions;

import com.dojo.solid.agents.Agent;
import com.dojo.solid.missions.Mission;

import java.util.List;

public class BackedMission extends Mission {
    private List<Agent> backup;

    public BackedMission(String id, String name, Agent agent, List<Agent> backup) {
        super(id, name, agent);
        this.backup = backup;
    }

    public BackedMission(String id, String name, Agent agent, List<Agent> backup, long startDate) {
        super(id, name, agent, startDate);
        this.backup = backup;
    }

    public List<Agent> getBackup() {
        return backup;
    }

    public void setBackup(List<Agent> backup) {
        this.backup = backup;
    }
}

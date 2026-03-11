package com.dojo.solid.missions;

import com.dojo.solid.standards.repositories.Repository;

import java.util.List;

public interface MissionsRepository extends Repository<Mission, String> {
    List<Mission> findByAgent(String agentId);
}

package com.dojo.solid.missions;

import com.dojo.solid.standards.repositories.Add;
import com.dojo.solid.standards.repositories.FindAll;
import com.dojo.solid.standards.repositories.FindById;

import java.util.List;

public interface MissionsRepository extends
        Add<Mission>,
        FindAll<Mission>,
        FindById<Mission, String> {

    List<Mission> findByAgent(String agentId);
}

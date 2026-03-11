package com.dojo.solid.agents;

import com.dojo.solid.standards.repositories.Add;
import com.dojo.solid.standards.repositories.FindAll;
import com.dojo.solid.standards.repositories.FindById;

public interface AgentsRepository extends Add<Agent>, FindAll<Agent>, FindById<Agent, String> {
}

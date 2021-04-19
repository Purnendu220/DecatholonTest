package com.abpl.decatholontest.models;

import java.io.Serializable;

public class FixtureModel implements Serializable {
    TeamModel teamA;
    TeamModel teamB;

    public FixtureModel(TeamModel teamA, TeamModel teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }

    public TeamModel getTeamA() {
        return teamA;
    }

    public void setTeamA(TeamModel teamA) {
        this.teamA = teamA;
    }

    public TeamModel getTeamB() {
        return teamB;
    }

    public void setTeamB(TeamModel teamB) {
        this.teamB = teamB;
    }
}

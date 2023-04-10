package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "TEAM")
public class Team {
    //TEAM_ID, NAME, STATE_ID, COLOR_ID, WINS, LOSSES
    @Id
    @GenericGenerator(name = "seq", strategy = "increment")
    @GeneratedValue(generator = "seq")
    @Column(name = "TEAM_ID")
    private Integer teamID;

    @Column(name = "NAME")
    private String name;

    @Column(name = "STATE_ID")
    private Integer stateID;

    @Column(name = "COLOR_ID")
    private Integer colorID;

    @Column(name = "WINS")
    private Integer wins;

    @Column(name = "LOSSES")
    private Integer losses;

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public Integer getColorID() {
        return colorID;
    }

    public void setColorID(Integer colorID) {
        this.colorID = colorID;
    }

    public Integer getWins() {
        return wins;
    }

    public void setWins(Integer wins) {
        this.wins = wins;
    }

    public Integer getLosses() {
        return losses;
    }

    public void setLosses(Integer losses) {
        this.losses = losses;
    }
}

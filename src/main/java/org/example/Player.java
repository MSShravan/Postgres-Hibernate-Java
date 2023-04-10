package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "PLAYER")
public class Player {
    //PLAYER_ID, TEAM_ID, UNIFORM_NUM, FIRST_NAME, LAST_NAME, MPG, PPG, RPG, APG, SPG, BPG
    @Id
    @GenericGenerator(name = "seq", strategy = "increment")
    @GeneratedValue(generator = "seq")
    @Column(name = "PLAYER_ID")
    private Integer playerID;

    @Column(name = "TEAM_ID")
    private Integer teamID;

    @Column(name = "UNIFORM_NUM")
    private Integer uniformNum;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "MPG")
    private Integer mpg;

    @Column(name = "PPG")
    private Integer ppg;

    @Column(name = "RPG")
    private Integer rpg;

    @Column(name = "APG")
    private Integer apg;

    @Column(name = "SPG")
    private Double spg;

    @Column(name = "BPG")
    private Double bpg;

    public Integer getPlayerID() {
        return playerID;
    }

    public void setPlayerID(Integer playerID) {
        this.playerID = playerID;
    }

    public Integer getTeamID() {
        return teamID;
    }

    public void setTeamID(Integer teamID) {
        this.teamID = teamID;
    }

    public Integer getUniformNum() {
        return uniformNum;
    }

    public void setUniformNum(Integer uniformNum) {
        this.uniformNum = uniformNum;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getMpg() {
        return mpg;
    }

    public void setMpg(Integer mpg) {
        this.mpg = mpg;
    }

    public Integer getPpg() {
        return ppg;
    }

    public void setPpg(Integer ppg) {
        this.ppg = ppg;
    }

    public Integer getRpg() {
        return rpg;
    }

    public void setRpg(Integer rpg) {
        this.rpg = rpg;
    }

    public Integer getApg() {
        return apg;
    }

    public void setApg(Integer apg) {
        this.apg = apg;
    }

    public Double getSpg() {
        return spg;
    }

    public void setSpg(Double spg) {
        this.spg = spg;
    }

    public Double getBpg() {
        return bpg;
    }

    public void setBpg(Double bpg) {
        this.bpg = bpg;
    }
}

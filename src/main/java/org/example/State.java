package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "STATE")
public class State {

    @Id
    @GenericGenerator(name = "seq", strategy = "increment")
    @GeneratedValue(generator = "seq")
    @Column(name = "STATE_ID")
    private Integer stateID;

    @Column(name = "NAME")
    private String name;

    public Integer getStateID() {
        return stateID;
    }

    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

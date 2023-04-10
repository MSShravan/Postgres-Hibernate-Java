package org.example;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "COLOR")
public class Color {

    @Id
    @GenericGenerator(name = "seq", strategy = "increment")
    @GeneratedValue(generator = "seq")
    @Column(name = "COLOR_ID")
    private Integer colorId;

    @Column(name = "NAME")
    private String name;

    public Integer getColorId() {
        return colorId;
    }

    public void setColorId(Integer colorId) {
        this.colorId = colorId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

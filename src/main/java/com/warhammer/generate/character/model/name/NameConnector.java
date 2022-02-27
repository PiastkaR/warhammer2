package com.warhammer.generate.character.model.name;

import com.warhammer.generate.character.model.description.Race;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "connectors")
public class NameConnector implements Serializable {
    private static final long serialVersionUID = -7817224776021728682L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String connector;
    @Column(nullable = false)
    private Race race;

    public NameConnector() {
    }

    public NameConnector(Long id, String connector, Race race) {
        this.id = id;
        this.connector = connector;
        this.race = race;
    }

    @Override
    public String toString() {
        return '\n' + "Connector{" +
                "id=" + id +
                ", connector=" + connector +
                ", raceConnector=" + race +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getConnector() {
        return connector;
    }

    public Race getRace() {
        return race;
    }
}

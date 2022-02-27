package com.warhammer.generate.character.model.name;

import com.warhammer.generate.character.model.description.Race;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "nicknames")
public class Nickname implements Serializable {
    private static final long serialVersionUID = 8562653542799920827L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String nickname;
    @Column(nullable = false)
    private Race race;

    public Nickname() {
    }

    public Nickname(Long id, String nickname, Race race) {
        this.id = id;
        this.nickname = nickname;
        this.race = race;
    }

    @Override
    public String toString() {
        return '\n' + "Nickname{" +
                "id=" + id +
                ", nickname=" + nickname  +
                ", raceNickname=" + race +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getNickname() {
        return nickname;
    }

        public Race getRace() {
        return race;
    }

}

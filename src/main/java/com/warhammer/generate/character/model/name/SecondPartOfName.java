package com.warhammer.generate.character.model.name;

import com.warhammer.generate.character.model.description.Gender;
import com.warhammer.generate.character.model.description.Race;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "names_second_part")
public class SecondPartOfName implements Serializable {
    private static final long serialVersionUID = 3907764199588983014L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Gender gender;
    @Column(nullable = false)
    private Race race;

    public SecondPartOfName() {
    }

    public SecondPartOfName(Long id, String name, Gender gender, Race race) {
        this.id = id;
        this.name = name;
        this.gender = gender;
        this.race = race;
    }

    @Override
    public String toString() {
        return '\n' + "Name{" +
                "id=" + id +
                ", name=" + name +
                ", gender=" + gender +
                ", race=" + race +
                '}';
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Gender getGender() {
        return gender;
    }

    public Race getRace() {
        return race;
    }

}

package com.warhammer.generate.character.model.skills;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "skill")
public class Skill implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "skill_id", nullable = false)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String test;

    @Override
    public String toString() {
        return '\n' + "Skill{" +
                "id=" + id +
                ", name=" + name +
                ", test=" + test +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return Objects.equals(id, skill.id) && Objects.equals(name, skill.name) && Objects.equals(test, skill.test);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, test);
    }
}

package com.warhammer.generate.character.model.abilities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity(name = "ability")
public class Ability implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ability_id", nullable = false)
    private  Long id;
    @Column(nullable = false)
    private  String name;
    @Column(nullable = true)
    private  String abilityDescription;

    public Ability() {
    }

    public Ability(Long id, String name, String abilityDescription) {
        this.id = id;
        this.name = name;
        this.abilityDescription = abilityDescription;
    }

    @Override
    public String toString() {
        return '\n' + "Ability{" +
                "id=" + id +
                ", name=" + name +
                ", abilityDescription=" + abilityDescription +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ability)) return false;
        Ability ability = (Ability) o;
        return Objects.equals(id, ability.id) && Objects.equals(name, ability.name) && Objects.equals(abilityDescription, ability.abilityDescription);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, abilityDescription);
    }
}

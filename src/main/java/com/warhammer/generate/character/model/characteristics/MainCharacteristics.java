package com.warhammer.generate.character.model.characteristics;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "main_characteristics", schema = "public")
public class MainCharacteristics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "combat_skills", nullable = true)
    private String combatSkills;
    @Column(name = "archery_skills", nullable = true)
    private String archerySkills;
    @Column(nullable = true)
    private String vim;
    @Column(nullable = true)
    private String hardiness;
    @Column(nullable = true)
    private String agility;
    @Column(nullable = true)
    private String intelligence;
    @Column(nullable = true)
    private String willpower;
    @Column(nullable = true)
    private String polish;

    public MainCharacteristics() {
    }

    public MainCharacteristics(int combatSkills, int archerySkills, int vim, int hardiness, int agility, int intelligence, int willpower, int polish) {
        this.combatSkills = Integer.toString(combatSkills);
        this.archerySkills = Integer.toString(archerySkills);
        this.vim = Integer.toString(vim);
        this.hardiness = Integer.toString(hardiness);
        this.agility = Integer.toString(agility);
        this.intelligence = Integer.toString(intelligence);
        this.willpower = Integer.toString(willpower);
        this.polish = Integer.toString(polish);
    }

    public int getCombatSkills() {
        return parseString(combatSkills);
    }

    public int getArcherySkills() {
        return parseString(archerySkills);
    }

    public int getVim() {
        return parseString(vim);
    }

    public int getHardiness() {
        return parseString(hardiness);
    }

    public int getAgility() {
        return parseString(agility);
    }

    public int getIntelligence() {
        return parseString(intelligence);
    }

    public int getWillpower() {
        return parseString(willpower);
    }

    public int getPolish() {
        return parseString(polish);
    }

    private int parseString(String value) {
        return Integer.parseInt(value);
    }

}

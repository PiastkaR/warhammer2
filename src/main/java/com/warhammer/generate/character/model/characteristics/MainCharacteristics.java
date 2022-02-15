package com.warhammer.generate.character.model.characteristics;

public class MainCharacteristics {

    private final int combatSkills;
    private final int archerySkills;
    private final int vim;
    private final int hardiness;
    private final int agility;
    private final int intelligence;
    private final int willpower;
    private final int polish;

    public MainCharacteristics(int combatSkills, int archerySkills, int vim, int hardiness, int agility, int intelligence, int willpower, int polish) {
        this.combatSkills = combatSkills;
        this.archerySkills = archerySkills;
        this.vim = vim;
        this.hardiness = hardiness;
        this.agility = agility;
        this.intelligence = intelligence;
        this.willpower = willpower;
        this.polish = polish;
    }

    public int getCombatSkills() {
        return combatSkills;
    }

    public int getArcherySkills() {
        return archerySkills;
    }

    public int getVim() {
        return vim;
    }

    public int getHardiness() {
        return hardiness;
    }

    public int getAgility() {
        return agility;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public int getWillpower() {
        return willpower;
    }

    public int getPolish() {
        return polish;
    }
}

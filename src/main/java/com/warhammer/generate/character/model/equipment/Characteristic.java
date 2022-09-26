package com.warhammer.generate.character.model.equipment;

public enum Characteristic {
    NORMAL(0, "zwykła"),
    HEAVY(1, "ciężka"),
    DEVASTATING(2, "druzgocący"),
    SHARDING(3, "odłamkowy"),
    DEAFENING(4, "ogłuszający"),
    PARRY(5, "parujący"),
    SLOW(6, "powolny"),
    PRECISE(7, "precyzyjny"),
    SPECIAL(8, "specjalny"),
    FAST(9, "szybki"),
    IMMOBILIZING(10, "unieruchamiający"),
    UNRELIABLE(11, "zawodny"),
    ARMOUR_PIERCING(12, "przebijający zbroję"),
    EXPERIMENTAL(14,"eksperymentalny"),
    BALANCED(13,"wyważony");

    private final int option;
    private final String description;

    Characteristic(int option, String description) {
        this.option = option;
        this.description = description;
    }

    @Override
    public String toString() {
        return "Category {" +
                "option=" + option + '\'' +
                ", description=" + description +
                '}';
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}

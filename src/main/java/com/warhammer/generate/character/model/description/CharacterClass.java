package com.warhammer.generate.character.model.description;

public enum CharacterClass {
    SCHOLAR(0, "Uczeni"),
    COMMONER(1, "Mieszczanie"),
    RANGER(2, "Wędrowcy"),
    CRIMINAL(3, "Łotry"),
    WARRIOR(4, "Wojownicy");

    private final int option;
    private final String description;

    CharacterClass(int option, String description) {
        this.option = option;
        this.description = description;
    }

    public int getOption() {
        return option;
    }

    public String getDescription() {
        return description;
    }
}

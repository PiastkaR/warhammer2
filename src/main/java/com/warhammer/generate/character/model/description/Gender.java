package com.warhammer.generate.character.model.description;

public enum Gender {
    MALE(0, "Mężczyzna"),
    FEMALE(1, "Kobieta"),
    BOTH(2, "1 Człon Imienia");

    private final int option;
    private final String description;

    Gender(int option, String description) {
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

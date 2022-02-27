package com.warhammer.generate.character.model.description;

public enum Race {
    HUMAN(0, "Człowiek"),
    HALFLING(1, "Niziołek"),
    DWARF(2, "Krasnolud"),
    ELF(3, "Elf");

    private final int option;
    private final String description;


    Race(int option, String description) {
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

package com.warhammer.generate.character.model.equipment;


import java.util.List;

public class Weapon extends Equipment {

    private final String category;
    private final String strength;
    private final String range;
    private final String reload;
    private final List<Characteristic> characteristics;

    public Weapon(Long id, String name, int load, String category, String strength, String range, String reload, List<Characteristic> characteristics) {
        super(id, name, load);
        this.category = category;
        this.strength = strength;
        this.range = range;
        this.reload = reload;
        this.characteristics = characteristics;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "category='" + category + '\'' +
                ", strength='" + strength + '\'' +
                ", range='" + range + '\'' +
                ", reload='" + reload + '\'' +
                ", characteristics=" + characteristics +
                '}';
    }

}

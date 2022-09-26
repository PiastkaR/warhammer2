package com.warhammer.generate.character.model.equipment;

import java.util.Objects;

public class Equipment  {


    private final Long id;
    private final String name;
    private final int load;

    public Equipment(Long id, String name, int load) {
        this.id = id;
        this.name = name;
        this.load = load;
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", load=" + load +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Equipment)) return false;
        Equipment equipment = (Equipment) o;
        return load == equipment.load && Objects.equals(id, equipment.id) && Objects.equals(name, equipment.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, load);
    }
}

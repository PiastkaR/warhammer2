package com.warhammer.generate.character.model.characteristics;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "secondary_characteristics")
public class SecondaryCharacteristics implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;
    @Column(nullable = true)
    private int attacks;
    @Column(nullable = true)
    private int vitality;
    @Column(nullable = true)
    private int strength;
    @Column(nullable = true)
    private int durability;
    @Column(nullable = true)
    private int speed;
    @Column(nullable = true)
    private int magic;
    @Column(nullable = true)
    private int insanityPoints;
    @Column(nullable = true)
    private int destinyPoints;

    public SecondaryCharacteristics() {
    }

    public SecondaryCharacteristics(int attacks, int vitality, int strength, int durability, int speed, int magic, int insanityPoints, int destinyPoints) {
        this.attacks = attacks;
        this.vitality = vitality;
        this.strength = strength;
        this.durability = durability;
        this.speed = speed;
        this.magic = magic;
        this.insanityPoints = insanityPoints;
        this.destinyPoints = destinyPoints;
    }

    public int getAttacks() {
        return attacks;
    }

    public int getVitality() {
        return vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getDurability() {
        return durability;
    }

    public int getSpeed() {
        return speed;
    }

    public int getMagic() {
        return magic;
    }

    public int getInsanityPoints() {
        return insanityPoints;
    }

    public int getDestinyPoints() {
        return destinyPoints;
    }
}

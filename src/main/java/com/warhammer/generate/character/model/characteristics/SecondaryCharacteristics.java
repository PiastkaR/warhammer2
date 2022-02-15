package com.warhammer.generate.character.model.characteristics;

public class SecondaryCharacteristics {

    private final int attacks;
    private final int vitality;
    private final int strength;
    private final int durability;
    private final int speed;
    private final int magic;
    private final int insanityPoints;
    private final int destinyPoints;

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

package com.warhammer.generate.character.utils.mechanics;

import com.warhammer.generate.character.model.characteristics.MainCharacteristics;
import com.warhammer.generate.character.model.characteristics.SecondaryCharacteristics;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicsGenerator {
    private static final int NUMBER_OF_ATTACKS = 1;
    private static final int LESS_IMPORTANT_POINTS = 0;
    private static final int DWARF_SPEED = 3;
    private static final int ELF_SPEED = 5;
    private static final int HUMAN_SPEED = 4;

    private final DiceThrowGenerator diceThrow;
    private final VitalityGenerator vitalityGenerator;
    private final DestinyPointsGenerator destinyPointsGenerator;

    public CharacteristicsGenerator(DiceThrowGenerator diceThrow, VitalityGenerator vitalityGenerator, DestinyPointsGenerator destinyPointsGenerator) {
        this.diceThrow = diceThrow;
        this.vitalityGenerator = vitalityGenerator;
        this.destinyPointsGenerator = destinyPointsGenerator;
    }

    public MainCharacteristics generateHumanMainCharacteristics() {
        return new MainCharacteristics(
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty()
        );
    }

    public MainCharacteristics generateElfMainCharacteristics() {
        return new MainCharacteristics(
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusThirty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusThirty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty()
        );
    }

    public MainCharacteristics generateDwarfMainCharacteristics() {
        return new MainCharacteristics(
                diceThrow.twoK10PlusThirty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusThirty(),
                diceThrow.twoK10PlusTen(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTen()
        );
    }

    public MainCharacteristics generateHalflingMainCharacteristics() {
        return new MainCharacteristics(
                diceThrow.twoK10PlusTen(),
                diceThrow.twoK10PlusThirty(),
                diceThrow.twoK10PlusTen(),
                diceThrow.twoK10PlusTen(),
                diceThrow.twoK10PlusThirty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusTwenty(),
                diceThrow.twoK10PlusThirty()
        );
    }

    public SecondaryCharacteristics generateHumanSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                NUMBER_OF_ATTACKS,
                generateHumanVitality(diceThrow),
                strength,
                durability,
                HUMAN_SPEED,
                LESS_IMPORTANT_POINTS,
                LESS_IMPORTANT_POINTS,
                generateHumanDestinyPoints(diceThrow)
        );
    }

    public SecondaryCharacteristics generateElfSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                NUMBER_OF_ATTACKS,
                generateElfVitality(diceThrow),
                strength,
                durability,
                ELF_SPEED,
                LESS_IMPORTANT_POINTS,
                LESS_IMPORTANT_POINTS,
                generateElfDestinyPoints(diceThrow)
        );
    }

    public SecondaryCharacteristics generateDwarfSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                NUMBER_OF_ATTACKS,
                generateDwarfVitality(diceThrow),
                strength,
                durability,
                DWARF_SPEED,
                LESS_IMPORTANT_POINTS,
                LESS_IMPORTANT_POINTS,
                generateDwarfDestinyPoints(diceThrow)
        );
    }

    public SecondaryCharacteristics generateHalflingSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                NUMBER_OF_ATTACKS,
                generateHalflingVitality(diceThrow),
                strength,
                durability,
                HUMAN_SPEED,
                LESS_IMPORTANT_POINTS,
                LESS_IMPORTANT_POINTS,
                generateHalflingDestinyPoints(diceThrow)
        );
    }

    private int generateHumanVitality(DiceThrowGenerator diceThrow) {
        return vitalityGenerator.getHumanVitality(diceThrow.k10Throw());
    }

    private int generateElfVitality(DiceThrowGenerator diceThrow) {
        return vitalityGenerator.getElfVitality(diceThrow.k10Throw());
    }

    private int generateDwarfVitality(DiceThrowGenerator diceThrow) {
        return vitalityGenerator.getDwarfVitality(diceThrow.k10Throw());
    }

    private int generateHalflingVitality(DiceThrowGenerator diceThrow) {
        return vitalityGenerator.getHalflingVitality(diceThrow.k10Throw());
    }

    private int generateHumanDestinyPoints(DiceThrowGenerator diceThrow) {
        return destinyPointsGenerator.generateHumanDestinyPoints(diceThrow.k10Throw());
    }

    private int generateElfDestinyPoints(DiceThrowGenerator diceThrow) {
        return destinyPointsGenerator.generateElfDestinyPoints(diceThrow.k10Throw());
    }

    private int generateDwarfDestinyPoints(DiceThrowGenerator diceThrow) {
        return destinyPointsGenerator.generateDwarfDestinyPoints(diceThrow.k10Throw());
    }

    private int generateHalflingDestinyPoints(DiceThrowGenerator diceThrow) {
        return destinyPointsGenerator.generateHalflingDestinyPoints(diceThrow.k10Throw());
    }

}

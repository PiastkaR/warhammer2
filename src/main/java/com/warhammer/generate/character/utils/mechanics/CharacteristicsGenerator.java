package com.warhammer.generate.character.utils.mechanics;

import com.warhammer.generate.character.model.characteristics.DestinyPointsGenerator;
import com.warhammer.generate.character.model.characteristics.MainCharacteristics;
import com.warhammer.generate.character.model.characteristics.SecondaryCharacteristics;
import com.warhammer.generate.character.model.characteristics.VitalityGenerator;
import org.springframework.stereotype.Service;

@Service
public class CharacteristicsGenerator {

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
                1,
                generateHumanVitality(diceThrow),
                strength,
                durability,
                4,
                0,
                0,
                generateHumanDestinyPoints(diceThrow)
                );
    }

    public SecondaryCharacteristics generateElfSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                1,
                generateElfVitality(diceThrow),
                strength,
                durability,
                5,
                0,
                0,
                generateElfDestinyPoints(diceThrow)
        );
    }

    public SecondaryCharacteristics generateDwarfSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                1,
                generateDwarfVitality(diceThrow),
                strength,
                durability,
                3,
                0,
                0,
                generateDwarfDestinyPoints(diceThrow)
        );
    }

    public SecondaryCharacteristics generateHalflingSecondaryCharacteristics(MainCharacteristics mainCharacteristics) {
        int strength = MechanicsUtils.getTensFromDigit(mainCharacteristics.getHardiness());
        int durability = MechanicsUtils.getTensFromDigit(mainCharacteristics.getVim());

        return new SecondaryCharacteristics(
                1,
                generateHalflingVitality(diceThrow),
                strength,
                durability,
                4,
                0,
                0,
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

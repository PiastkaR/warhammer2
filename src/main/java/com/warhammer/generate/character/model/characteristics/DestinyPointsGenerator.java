package com.warhammer.generate.character.model.characteristics;

import com.warhammer.generate.character.utils.mechanics.MechanicsUtils;
import org.springframework.stereotype.Component;

@Component
public class DestinyPointsGenerator {

    public int generateHumanDestinyPoints(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 4)) {
            return 2;
        }
        if (MechanicsUtils.isBetween(k10throw, 5, 10)) {
            return 3;
        }
        return 2;
    }

    public int generateElfDestinyPoints(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 4)) {
            return 1;
        }
        if (MechanicsUtils.isBetween(k10throw, 5, 10)) {
            return 2;
        }

        return 1;
    }

    public int generateDwarfDestinyPoints(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 4)) {
            return 1;
        }
        if (MechanicsUtils.isBetween(k10throw, 5, 7)) {
            return 2;
        }
        if (MechanicsUtils.isBetween(k10throw, 8, 10)) {
            return 3;
        }
        return 1;
    }

    public int generateHalflingDestinyPoints(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 4)) {
            return 2;
        }
        if (MechanicsUtils.isBetween(k10throw, 5, 7)) {
            return 2;
        }
        if (MechanicsUtils.isBetween(k10throw, 8, 10)) {
            return 3;
        }
        return 2;
    }

}

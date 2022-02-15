package com.warhammer.generate.character.model.characteristics;

import com.warhammer.generate.character.utils.mechanics.MechanicsUtils;
import org.springframework.stereotype.Component;

@Component
public class VitalityGenerator {

    public int getHumanVitality(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 3)) {
            return 10;
        }
        if (MechanicsUtils.isBetween(k10throw, 4, 7)) {
            return 11;
        }

        if (MechanicsUtils.isBetween(k10throw, 7, 9)) {
            return 12;
        }

        if (MechanicsUtils.isBetween(k10throw, 10, 10)) {
            return 13;
        }
        return 10;
    }

    public int getElfVitality(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 3)) {
            return 9;
        }
        if (MechanicsUtils.isBetween(k10throw, 4, 7)) {
            return 10;
        }

        if (MechanicsUtils.isBetween(k10throw, 7, 9)) {
            return 11;
        }

        if (MechanicsUtils.isBetween(k10throw, 10, 10)) {
            return 12;
        }
        return 9;
    }

    public int getDwarfVitality(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 3)) {
            return 11;
        }
        if (MechanicsUtils.isBetween(k10throw, 4, 7)) {
            return 12;
        }

        if (MechanicsUtils.isBetween(k10throw, 7, 9)) {
            return 13;
        }

        if (MechanicsUtils.isBetween(k10throw, 10, 10)) {
            return 14;
        }
        return 11;
    }

    public int getHalflingVitality(int k10throw) {
        if (MechanicsUtils.isBetween(k10throw, 1, 3)) {
            return 8;
        }
        if (MechanicsUtils.isBetween(k10throw, 4, 7)) {
            return 9;
        }

        if (MechanicsUtils.isBetween(k10throw, 7, 9)) {
            return 10;
        }

        if (MechanicsUtils.isBetween(k10throw, 10, 10)) {
            return 11;
        }
        return 8;
    }

}

package com.warhammer.generate.character.utils.mechanics;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class DiceThrowGenerator {

    private int result;

    public int getResult() {
        return result;
    }

    public int k10Throw() {
        int diceThrow = new Random().nextInt(10) + 1;
        this.result = diceThrow;

        return result;
    }

    public int k100Throw() {
        int diceThrow = new Random().nextInt(100) + 1;
        this.result = diceThrow;

        return result;
    }

    public int twoK10PlusTwenty() {
        return 2 * k10Throw() + 20;
    }

    public int twoK10PlusThirty() {
        return 2 * k10Throw() + 20;
    }

    public int twoK10PlusTen() {
        return 2 * k10Throw() + 20;
    }

}

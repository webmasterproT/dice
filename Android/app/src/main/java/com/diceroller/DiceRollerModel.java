```java
package com.diceroller;

import java.util.Random;

public class DiceRollerModel {
    private int numberOfDice;
    private int diceType;
    private int modifier;
    private boolean isAddModifier;

    public DiceRollerModel() {
        this.numberOfDice = 1;
        this.diceType = 6;
        this.modifier = 0;
        this.isAddModifier = true;
    }

    public int getNumberOfDice() {
        return numberOfDice;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public int getDiceType() {
        return diceType;
    }

    public void setDiceType(int diceType) {
        this.diceType = diceType;
    }

    public int getModifier() {
        return modifier;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public boolean isAddModifier() {
        return isAddModifier;
    }

    public void setAddModifier(boolean addModifier) {
        isAddModifier = addModifier;
    }

    public int rollDice() {
        Random random = new Random();
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            total += random.nextInt(diceType) + 1;
        }
        if (isAddModifier) {
            total += modifier;
        } else {
            total -= modifier;
        }
        return total;
    }
}
```
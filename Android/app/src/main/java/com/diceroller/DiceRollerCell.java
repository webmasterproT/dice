```java
package com.diceroller;

import java.util.Random;

public class DiceRollerCell {

    private int numberOfDice;
    private int diceType;
    private int modifier;
    private boolean isAddModifier;

    public DiceRollerCell() {
        this.numberOfDice = 1;
        this.diceType = 6;
        this.modifier = 0;
        this.isAddModifier = true;
    }

    public void setNumberOfDice(int numberOfDice) {
        this.numberOfDice = numberOfDice;
    }

    public void setDiceType(int diceType) {
        this.diceType = diceType;
    }

    public void setModifier(int modifier) {
        this.modifier = modifier;
    }

    public void setAddModifier(boolean addModifier) {
        isAddModifier = addModifier;
    }

    public int rollDice() {
        Random rand = new Random();
        int total = 0;
        for (int i = 0; i < numberOfDice; i++) {
            total += rand.nextInt(diceType) + 1;
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
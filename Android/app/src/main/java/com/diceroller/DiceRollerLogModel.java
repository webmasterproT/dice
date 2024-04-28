```java
package com.diceroller;

import java.util.ArrayList;
import java.util.List;

public class DiceRollerLogModel {

    private List<String> rolls;

    public DiceRollerLogModel() {
        this.rolls = new ArrayList<>();
    }

    public List<String> getRolls() {
        return rolls;
    }

    public void addRollToLog(String roll) {
        this.rolls.add(roll);
    }
}
```
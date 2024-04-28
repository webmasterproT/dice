```java
package com.diceroller;

import java.util.ArrayList;

public class DiceRollerLogController {

    private DiceRollerLogModel logModel;
    private DiceRollerLogView logView;

    public DiceRollerLogController(DiceRollerLogModel logModel, DiceRollerLogView logView) {
        this.logModel = logModel;
        this.logView = logView;
    }

    public void addRollToLog(String roll) {
        logModel.getRolls().add(roll);
        logView.updateLog(logModel.getRolls());
    }

    public ArrayList<String> getRolls() {
        return logModel.getRolls();
    }
}
```
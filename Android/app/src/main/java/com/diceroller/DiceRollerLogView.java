```java
package com.diceroller;

import android.view.View;
import android.widget.TextView;
import java.util.ArrayList;

public class DiceRollerLogView {

    private View logScreen;
    private ArrayList<TextView> logEntries;

    public DiceRollerLogView(View logScreen) {
        this.logScreen = logScreen;
        this.logEntries = new ArrayList<>();
    }

    public void addLogEntry(String entry) {
        TextView logEntry = new TextView(logScreen.getContext());
        logEntry.setText(entry);
        logEntries.add(logEntry);
        ((ViewGroup) logScreen).addView(logEntry);
    }

    public void clearLog() {
        for (TextView logEntry : logEntries) {
            ((ViewGroup) logScreen).removeView(logEntry);
        }
        logEntries.clear();
    }
}
```
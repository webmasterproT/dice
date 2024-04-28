```java
package com.diceroller;

import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class DiceRollerView {

    private TextView diceNumber;
    private Spinner diceType;
    private Spinner modifier;
    private Button rollButton;

    public DiceRollerView(View view) {
        diceNumber = view.findViewById(R.id.diceNumber);
        diceType = view.findViewById(R.id.diceType);
        modifier = view.findViewById(R.id.modifier);
        rollButton = view.findViewById(R.id.rollButton);

        ArrayAdapter<CharSequence> diceTypeAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.dice_types, android.R.layout.simple_spinner_item);
        diceTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceType.setAdapter(diceTypeAdapter);

        ArrayAdapter<CharSequence> modifierAdapter = ArrayAdapter.createFromResource(view.getContext(),
                R.array.modifiers, android.R.layout.simple_spinner_item);
        modifierAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        modifier.setAdapter(modifierAdapter);
    }

    public TextView getDiceNumber() {
        return diceNumber;
    }

    public Spinner getDiceType() {
        return diceType;
    }

    public Spinner getModifier() {
        return modifier;
    }

    public Button getRollButton() {
        return rollButton;
    }
}
```
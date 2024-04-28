```java
package com.diceroller;

import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class DiceRollerController {

    private DiceRollerModel model;
    private DiceRollerView view;

    public DiceRollerController(DiceRollerModel model, DiceRollerView view) {
        this.model = model;
        this.view = view;
        setupListeners();
    }

    private void setupListeners() {
        view.getDiceNumber().addTextChangedListener(new SimpleTextWatcher() {
            @Override
            public void onTextChanged(String s) {
                updateDiceNumber(s);
            }
        });

        view.getDiceType().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateDiceType(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        view.getModifier().setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                updateModifier(parent.getItemAtPosition(position).toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });
    }

    private void updateDiceNumber(String number) {
        try {
            int num = Integer.parseInt(number);
            model.setNumberOfDice(num);
        } catch (NumberFormatException e) {
            // Handle exception
        }
    }

    private void updateDiceType(String type) {
        model.setTypeOfDice(type);
    }

    private void updateModifier(String modifier) {
        model.setModifier(modifier);
    }
}
```
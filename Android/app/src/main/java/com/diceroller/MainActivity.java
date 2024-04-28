```java
package com.diceroller;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity {

    private DiceRollerModel diceRollerModel;
    private DiceRollerController diceRollerController;
    private DiceRollerLogController diceRollerLogController;

    private TextView diceNumber;
    private Spinner diceType;
    private Spinner modifier;
    private Button rollButton;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceRollerModel = new DiceRollerModel();
        diceRollerController = new DiceRollerController(diceRollerModel);
        diceRollerLogController = new DiceRollerLogController();

        diceNumber = findViewById(R.id.diceNumber);
        diceType = findViewById(R.id.diceType);
        modifier = findViewById(R.id.modifier);
        rollButton = findViewById(R.id.rollButton);
        drawerLayout = findViewById(R.id.drawerLayout);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.dice_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        diceType.setAdapter(adapter);

        rollButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int number = Integer.parseInt(diceNumber.getText().toString());
                String type = diceType.getSelectedItem().toString();
                String mod = modifier.getSelectedItem().toString();

                diceRollerController.updateDiceNumber(number);
                diceRollerController.updateDiceType(type);
                diceRollerController.updateModifier(mod);

                int result = diceRollerController.rollDice();
                diceRollerLogController.addRollToLog(result);
            }
        });
    }

    public void openLogScreen() {
        drawerLayout.openDrawer(findViewById(R.id.logScreen));
    }

    public void closeLogScreen() {
        drawerLayout.closeDrawer(findViewById(R.id.logScreen));
    }
}
```
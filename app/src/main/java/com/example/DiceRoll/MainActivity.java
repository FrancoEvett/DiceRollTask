package com.example.DiceRoll;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private TextView DiceRollOutput;
    private TextView CongratText;
    private TextView UserGuess;
    private Random DiceRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        //can create some setup code here, note - find out how to impliment basic java classes main(string args) or if it is replaced by this method
        DiceRollOutput = this.findViewById(R.id.RollResultText); //get reference to roll ouput
        CongratText = this.findViewById(R.id.CongratulationsText);
        UserGuess = this.findViewById(R.id.UserGuess);
        DiceRandom = new Random(); //cfeate a new random number generator
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void RollTheDice(View view){
        //roll die button clicked - dont forget to link this to the button in the veiw editor

        //generate and display the random die roll reult to the user
        int numberDie = DiceRandom.nextInt(6);
        DiceRollOutput.setText("Rolled : "+Integer.toString(numberDie));

        //check for the correct guess from the user and display the congratulatory text or conolation message
        if (Integer.toString(numberDie).equals(UserGuess.getText().toString())){

            CongratText.setText("Congratulations :D");
        }
        else {

            CongratText.setText("Better Luck Next Time :C");
        }



    }
}



























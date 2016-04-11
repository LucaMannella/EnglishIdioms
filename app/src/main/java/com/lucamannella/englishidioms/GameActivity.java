package com.lucamannella.englishidioms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Luca on 11/04/2016.
 */
public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
    }


    public void checkSolution(View view) {
        String solution = ((EditText)findViewById(R.id.solution_edit_text)).getText().toString().trim();

        if(solution.equalsIgnoreCase("Schifo")) {
            findViewById(R.id.explanation_text_view).setVisibility(View.VISIBLE);
            findViewById(R.id.next_button).setVisibility(View.VISIBLE);
        }
        else {
            Toast.makeText(this, "Pensaci meglio!", Toast.LENGTH_SHORT).show();
        }
    }

    public void nextActivity(View view) {
        Toast.makeText(this, "Please, implement me! :(", Toast.LENGTH_SHORT).show();
    }

}

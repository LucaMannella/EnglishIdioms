package com.lucamannella.englishidioms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by Luca on 11/04/2016.
 */
public class GameActivity extends AppCompatActivity {

    int vet[] = {R.drawable.example, R.drawable.france_flag, R.drawable.italy_flag, R.drawable.germany_flag, R.drawable.spain_flag};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ((ImageView)findViewById(R.id.rebus_picture)).setImageResource(vet[i++]);
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
        findViewById(R.id.explanation_text_view).setVisibility(View.GONE);
        findViewById(R.id.next_button).setVisibility(View.GONE);
        ((ImageView)findViewById(R.id.rebus_picture)).setImageResource(vet[i]);
        i = (i+1)%5;
    }

}

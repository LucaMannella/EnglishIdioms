package com.lucamannella.englishidioms;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.KeyListener;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This activity will manage the game.
 * Created by Luca on 11/04/2016.
 * @author Luca
 */
public class GameActivity extends AppCompatActivity {

    private String[] rebusHints;
    private String[] solutions;
    private String[] explanations;

    int rebus[] = {R.drawable.france_flag,
            R.drawable.italy_flag,
            R.drawable.germany_flag, R.drawable.spain_flag, R.drawable.english_flag};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Resources resources = getResources();
        // retrieving the arrays from the xml file
        rebusHints = resources.getStringArray(R.array.rebus_hints);
        solutions = resources.getStringArray(R.array.rebus_solutions);
        explanations = resources.getStringArray(R.array.rebus_explenation);

        ((TextView) findViewById(R.id.rebus_number_text_view)).setText("Rebus #1 of "+solutions.length);
        ((ImageView)findViewById(R.id.rebus_picture)).setImageResource( rebus[i] );
        ((TextView) findViewById(R.id.rebus_hint_text_view)).setText( rebusHints[i] );
    }


    /**
     * This method checks if the solution is right or not.
     * @param view - The button that was pressed to start this method.
     */
    public void checkSolution(View view) {
        EditText solutionEditText = (EditText)findViewById(R.id.solution_edit_text);
        String solution = solutionEditText.getText().toString().trim();

        if(solution.equalsIgnoreCase(solutions[i])) {
            TextView translation = (TextView)findViewById(R.id.translation_text_view);
            translation.setText(solutions[i]);
            translation.setVisibility(View.VISIBLE);

            TextView explanation = (TextView)findViewById(R.id.explanation_text_view);
            explanation.setText(explanations[i]);
            explanation.setVisibility(View.VISIBLE);

            findViewById(R.id.next_button).setVisibility(View.VISIBLE);

            solutionEditText.setTag(solutionEditText.getKeyListener());
            solutionEditText.setKeyListener(null);
            findViewById(R.id.submit_button).setClickable(false);

            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    ScrollView scrollView = (ScrollView)findViewById(R.id.game_scroll_view);
                    View targetView = findViewById(R.id.submit_button);

                    if(scrollView != null && targetView != null)
                        scrollView.scrollTo(0, targetView.getBottom());
                }
            });
        }
        else {
            Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method updates the GameActivity to the next rebus.
     * @param view - The button that was pressed to start this method.
     */
    public void nextActivity(View view) {
        findViewById(R.id.translation_text_view).setVisibility(View.GONE);
        findViewById(R.id.explanation_text_view).setVisibility(View.GONE);
        findViewById(R.id.next_button).setVisibility(View.GONE);

        EditText solutionEditText = (EditText) findViewById(R.id.solution_edit_text);
        solutionEditText.setKeyListener((KeyListener) solutionEditText.getTag());
        solutionEditText.setText("");
        findViewById(R.id.submit_button).setClickable(true);

        i++;
        if(i < solutions.length) {
            ((TextView) findViewById(R.id.rebus_number_text_view)).setText("Rebus #"+(i+1)+" of "+ solutions.length);
            ((ImageView)findViewById(R.id.rebus_picture)).setImageResource(rebus[i]);
            ((TextView) findViewById(R.id.rebus_hint_text_view)).setText(rebusHints[i]);

            // This Runnable object scroll up to the top the text view.
            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    ScrollView scrollView = (ScrollView)findViewById(R.id.game_scroll_view);

                    if(scrollView != null)
                        scrollView.fullScroll(ScrollView.FOCUS_UP);
                }
            });
        }
        else {  //Game completed! go the game over activity!
            Intent intent = new Intent(this, GameOverActivity.class);
            startActivity(intent);
            finish();
        }
    }

}

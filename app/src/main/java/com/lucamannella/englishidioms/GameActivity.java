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
    private String[] translations;
    private String[] explanations;

    int rebus[] = {R.drawable.raining_cats_dogs, R.drawable.cut_your_teeth,
            R.drawable.same_page, R.drawable.hit_the_roof, R.drawable.as_good_as_gold};

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        Resources resources = getResources();
        // retrieving the arrays from the xml file
        rebusHints = resources.getStringArray(R.array.rebus_hints);
        solutions = resources.getStringArray(R.array.rebus_solutions);
        translations = resources.getStringArray(R.array.translations);
        explanations = resources.getStringArray(R.array.rebus_explenation);

        ((TextView) findViewById(R.id.rebus_number_text_view)).setText("Rebus #1 of "+solutions.length);
        ((ImageView)findViewById(R.id.rebus_picture)).setImageResource( rebus[i] );
        ((TextView) findViewById(R.id.rebus_hint_text_view)).setText( rebusHints[i] );
    }


    /**
     * This method checks if the solution is right or not.
     * @param submitButton - The button that was pressed to start this method.
     */
    public void checkSolution(View submitButton) {
        EditText solutionEditText = (EditText)findViewById(R.id.solution_edit_text);
        String solution = solutionEditText.getText().toString().trim();

        if(solution.equalsIgnoreCase(solutions[i])) {
            // the EditText is no more editable
            solutionEditText.setTag(solutionEditText.getKeyListener());
            solutionEditText.setKeyListener(null);
            // submit button no clickable anymore
            submitButton.setClickable(false);

            // filling and showing the translation TextView
            TextView translation = (TextView)findViewById(R.id.translation_text_view);
            translation.setText(translations[i]);
            translation.setVisibility(View.VISIBLE);

            // filling and showing the explanation TextView
            TextView explanation = (TextView)findViewById(R.id.explanation_text_view);
            explanation.setText(explanations[i]);
            explanation.setVisibility(View.VISIBLE);

            // showing the next button
            findViewById(R.id.next_button).setVisibility(View.VISIBLE);

            // this Runnable object will scroll the ScrollView to show the explanation
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
        else {  // wrong answer
            Toast.makeText(this, R.string.wrong_answer, Toast.LENGTH_SHORT).show();
        }
    }

    /**
     * This method updates the GameActivity to the next rebus.
     * @param nextButton - The button that was pressed to start this method.
     */
    public void nextActivity(View nextButton) {
        i++;
        if(i < solutions.length) {  // if there are other rebus
            // hiding the views related to the solutions
            findViewById(R.id.translation_text_view).setVisibility(View.GONE);
            findViewById(R.id.explanation_text_view).setVisibility(View.GONE);
            nextButton.setVisibility(View.GONE);

            // the solution EditText is emptied and again editable
            EditText solutionEditText = (EditText) findViewById(R.id.solution_edit_text);
            solutionEditText.setText("");
            solutionEditText.setKeyListener((KeyListener) solutionEditText.getTag());

            // the rebus is updated
            ((TextView) findViewById(R.id.rebus_number_text_view)).setText("Rebus #"+(i+1)+" of "+ solutions.length);
            ((ImageView)findViewById(R.id.rebus_picture)).setImageResource(rebus[i]);
            ((TextView) findViewById(R.id.rebus_hint_text_view)).setText(rebusHints[i]);

            // the submit button is clickable again
            findViewById(R.id.submit_button).setClickable(true);

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

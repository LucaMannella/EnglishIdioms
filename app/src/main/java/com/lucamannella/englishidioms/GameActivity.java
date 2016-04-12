package com.lucamannella.englishidioms;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
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

    int vet[] = {R.drawable.france_flag,
            R.drawable.italy_flag,
            R.drawable.germany_flag, R.drawable.spain_flag};

    String rebusHints[] = {"5", "8 - 3 - 5", "6 - 6", "6"};
    String solutions[] = {"Schifo", "Campioni del mondo", "mangia crauti", "fiesta"};
    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        ((ImageView)findViewById(R.id.rebus_picture)).setImageResource( vet[i] );
        ((TextView) findViewById(R.id.rebus_hint_text_view)).setText( rebusHints[i] );

        EditText editText = ((EditText)findViewById(R.id.solution_edit_text));

        if(editText != null)
            // here I create an editorActionListener that response when the editText content changes
            editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
                /**
                 * This method calls the checkSolution() method.
                 */
                public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                    if ((event != null && (event.getKeyCode() == KeyEvent.KEYCODE_ENTER))
                            || (actionId == EditorInfo.IME_ACTION_DONE)) {

                        checkSolution(v); //v is not used
                    }
                    return false;
                }
            });
    }


    /**
     * This method checks if the solution is right or not.
     * @param view - The button that was pressed to start this method.
     */
    public void checkSolution(View view) {
        EditText solutionEditText = (EditText)findViewById(R.id.solution_edit_text);
        String solution = solutionEditText.getText().toString().trim();

        if(solution.equalsIgnoreCase(solutions[i])) {
            findViewById(R.id.explanation_text_view).setVisibility(View.VISIBLE);
            findViewById(R.id.next_button).setVisibility(View.VISIBLE);

            solutionEditText.setTag(solutionEditText.getKeyListener());
            solutionEditText.setKeyListener(null);

            new Handler().post(new Runnable() {
                @Override
                public void run() {
                    ScrollView scrollView = (ScrollView)findViewById(R.id.game_scroll_view);
                    TextView textView = (TextView)findViewById(R.id.explanation_text_view);

                    scrollView.scrollTo(0, textView.getBottom());
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
        findViewById(R.id.explanation_text_view).setVisibility(View.GONE);
        findViewById(R.id.next_button).setVisibility(View.GONE);

        EditText solutionEditText = (EditText) findViewById(R.id.solution_edit_text);
        solutionEditText.setKeyListener((KeyListener) solutionEditText.getTag());
        solutionEditText.setText("");

        i = (i+1) % vet.length;
        ((ImageView)findViewById(R.id.rebus_picture)).setImageResource( vet[i] );
        ((TextView) findViewById(R.id.rebus_hint_text_view)).setText( rebusHints[i] );
    }

}

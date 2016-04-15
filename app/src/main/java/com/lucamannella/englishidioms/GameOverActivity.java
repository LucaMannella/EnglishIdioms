package com.lucamannella.englishidioms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * This is the last activity of the game.
 * Created by Luca on 11/04/2016.
 * @author Luca
 */
public class GameOverActivity extends AppCompatActivity {

    private final static String eMail = "luca.mannella@studenti.polito.it";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }

    /**
     * This method send an e-mail to the creator of the application (me :D)!
     * @param view - The button that was pressed to start this method (not used).
     */
    public void mailMe (View view) {
        String subject = getResources().getString(R.string.email_subject_feedback);
        Utility.sendEmail(eMail, subject, getResources().getString(R.string.email_feedback_text), this);
    }

    /**
     * This method terminates the activity.
     * @param view - The button that was pressed to start this method (not used).
     */
    public void goBackToMenu (View view) {
        finish();
    }

}

package com.lucamannella.englishidioms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class GameOverActivity extends AppCompatActivity {

    private final static String eMail = "luca.mannella@studenti.polito.it";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }

    public void mailMe (View view) {
        String subject = getResources().getString(R.string.email_subject_feedback);
        Utility.sendEmail(eMail, subject, getResources().getString(R.string.email_feedback_text), this);
    }

    public void goBackToMenu (View view) {
        finish();
    }

}

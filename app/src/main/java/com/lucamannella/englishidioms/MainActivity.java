package com.lucamannella.englishidioms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * This activity is the main class of the application.
 * Created by Luca on 09/04/2016.
 * @author Luca
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method will start the activity in which the user will play.
     * @param view - The button that was pressed to start this method.
     */
    public void startGameActivity(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    /**
     * This method will open the activity related to the language selection.
     * @param view - The button that was pressed to start this method.
     */
    public void startLanguageActivity (View view) {
        Intent intent = new Intent(this, LanguageActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This method will allow the user to invite your friends.
     * @param view - The button that was pressed to start this method.
     */
    public void inviteFriends(View view) {
        String subject = getResources().getString(R.string.email_subject_invite_friends);
        String text = getResources().getString(R.string.email_invite_friends_text);

        if( !Utility.sendEmail(null, subject, text, this) )
            Toast.makeText(this, R.string.email_not_sent, Toast.LENGTH_SHORT).show();
    }

}

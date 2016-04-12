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
    }

    /**
     * This method will manage the google app invite.
     * @param view - The button that was pressed to start this method.
     */
    public void startAppInviteActivity (View view) {
        Toast.makeText(this, "Implement me! :(", Toast.LENGTH_SHORT).show();
    }

}

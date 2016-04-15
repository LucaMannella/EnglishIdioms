package com.lucamannella.englishidioms;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

/**
 * This activity will show the splash screen and will call the main activity.
 * Created by Luca on 12/04/2016.
 * @author Luca
 */
public class SplashScreenActivity extends AppCompatActivity {

    private final static int DISPLAY_ACTIVITY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // this runnable object will call the main activity after the set time.
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, DISPLAY_ACTIVITY);

        setContentView(R.layout.activity_splash_screen);
    }

}

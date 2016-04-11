package com.lucamannella.englishidioms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void gameActivity(View view) {
        Intent intent = new Intent(this, GameActivity.class);
        startActivity(intent);
    }

    public void settingsActivity (View view) {
        Toast.makeText(this, "Implement me! :(", Toast.LENGTH_SHORT).show();
    }

    public void appInviteActivity (View view) {
        Toast.makeText(this, "Implement me! :(", Toast.LENGTH_SHORT).show();
    }

}

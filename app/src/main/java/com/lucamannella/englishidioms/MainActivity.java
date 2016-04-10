package com.lucamannella.englishidioms;

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

    public void tostamelo(View view) {
        Toast.makeText(this, "Ciao sono un toast!", Toast.LENGTH_SHORT).show();
    }
}

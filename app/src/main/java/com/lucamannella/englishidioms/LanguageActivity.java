package com.lucamannella.englishidioms;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void setItalian(View view) {
        Toast.makeText(this, "Lingua italiana impostata con successo!", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void setFrench(View view) {
        Toast.makeText(this, "Unfortunately French is not yet avalaible! :(", Toast.LENGTH_SHORT).show();
        finishActivity(0);
    }

    public void setSpanish(View view) {
        Toast.makeText(this, "Unfortunately Spanish is not yet avalaible! :(", Toast.LENGTH_SHORT).show();
        finishActivity(0);
    }

    public void setGerman(View view) {
        Toast.makeText(this, "Unfortunately German is not yet avalaible! :(", Toast.LENGTH_SHORT).show();
        finishActivity(0);
    }
}

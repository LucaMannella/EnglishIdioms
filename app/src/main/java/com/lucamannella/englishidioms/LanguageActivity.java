package com.lucamannella.englishidioms;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

/**
 * This activity will manage the selection of the language.
 * Created by Luca on 10/04/2016.
 * @author Luca
 */
public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
    }

    public void setItalian(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("it_IT");
        Toast.makeText(this, R.string.italian_language_set, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setEnglish(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("en_EN");
        Toast.makeText(this, R.string.english_language_set, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setFrench(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("fr_FR");
        Toast.makeText(this, R.string.language_not_yet_available, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setSpanish(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("es_ES");
        Toast.makeText(this, R.string.language_not_yet_available, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void setGerman(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("de_DE");
        Toast.makeText(this, R.string.language_not_yet_available, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

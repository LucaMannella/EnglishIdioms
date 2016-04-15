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

    /**
     * This method sets the application language to italian (Italy).
     * @param view - The ImageButton that was pressed to start this method (not used).
     */
    public void setItalian(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("it_IT");
        Toast.makeText(this, R.string.italian_language_set, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This method sets the application language to english (United States).
     * @param view - The ImageButton that was pressed to start this method (not used).
     */
    public void setEnglish(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("en_US");
        Toast.makeText(this, R.string.english_language_set, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This method sets the application language to french (France).
     * Actually this language is not fully supported.
     * @param view - The ImageButton that was pressed to start this method (not used).
     */
    public void setFrench(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("fr_FR");
        Toast.makeText(this, R.string.language_not_yet_available, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This method sets the application language to spanish (Spain).
     * Actually this language is not fully supported.
     * @param view - The ImageButton that was pressed to start this method (not used).
     */
    public void setSpanish(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("es_ES");
        Toast.makeText(this, R.string.language_not_yet_available, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    /**
     * This method sets the application language to german (Germany).
     * Actually this language is not fully supported.
     * @param view - The ImageButton that was pressed to start this method (not used).
     */
    public void setGerman(View view) {
        ( (MyApplication)getApplicationContext() ).changeLang("de_DE");
        Toast.makeText(this, R.string.language_not_yet_available, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

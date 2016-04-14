package com.lucamannella.englishidioms;

import android.app.Application;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.preference.PreferenceManager;

import java.util.Locale;

/**
 * This class override the {@link Application} to manage a different language from the system one.
 * Created by Luca on 14/04/2016.
 * @author Luca
 */
public class MyApplication extends Application {

    // This is the object that manage the language.
    private Locale locale = null;

    @Override
    public void onCreate() {
        super.onCreate();
        SharedPreferences settings = PreferenceManager.getDefaultSharedPreferences(this);
        String lang = settings.getString(getString(R.string.locale_lang), "");
        changeLang(lang);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        if (locale != null) {
            Locale.setDefault(locale);
            Configuration config = new Configuration(newConfig);
            config.locale = locale;
            getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        }
    }

    /**
     * This method updates the language only inside the application.
     * @param lang - The language code following the {@link Locale} schema.
     */
    public void changeLang(String lang) {
        Configuration config = getBaseContext().getResources().getConfiguration();
        if (!"".equals(lang) && !config.locale.getLanguage().equals(lang))
        {
            SharedPreferences.Editor ed = PreferenceManager.getDefaultSharedPreferences(this).edit();
            ed.putString( getString(R.string.locale_lang), lang );
            ed.commit();

            locale = new Locale(lang);
            Locale.setDefault(locale);
            Configuration conf = new Configuration(config);
            conf.locale = locale;
            getBaseContext().getResources().updateConfiguration( conf, getBaseContext().getResources().getDisplayMetrics() );
        }
    }

    /**
     * This method returns the {@link Locale} code of the language currently set inside the application.
     * @return The current {@link Locale} code in the application
     */
    public String getLang(){
        return PreferenceManager.getDefaultSharedPreferences(this).getString(this.getString(R.string.locale_lang), "");
    }


}

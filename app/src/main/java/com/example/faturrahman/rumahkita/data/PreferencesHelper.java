package com.example.faturrahman.rumahkita.data;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
class PreferencesHelper {

    public static final String PREF_FILE_NAME = "rumahkita_pref_file";

    private final SharedPreferences pref;

    @Inject
    public PreferencesHelper(@ApplicationContext Context context) {
        pref = context.getSharedPreferences(PREF_FILE_NAME, Context.MODE_PRIVATE);
    }

    public void clear(){pref.edit().clear().apply();}

    public SharedPreferences get() {
        return pref;
    }
}

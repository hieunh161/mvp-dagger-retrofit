package vn.com.ndd.data.repository.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import vn.com.ndd.data.repository.SharedPreferencesRepository;
import vn.com.ndd.utils.Constants;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class SharedPreferencesRepositoryImpl implements SharedPreferencesRepository {
    private SharedPreferences mPrefs;

    public SharedPreferencesRepositoryImpl(Context context) {

        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
    }

    @Override
    public String getBaseUrl() {
        return mPrefs.getString(Constants.KEY_PREF_BASE_URL, Constants.BASE_URL);
    }

    @Override
    public void setBaseUrl(String baseUrl) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(Constants.KEY_PREF_BASE_URL, baseUrl);
        editor.apply();
    }
}

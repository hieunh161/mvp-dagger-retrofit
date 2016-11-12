package vn.com.ndd.data.repository.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.data.repository.SharedPreferencesRepository;
import vn.com.ndd.utils.Constants;

import static vn.com.ndd.utils.Constants.KEY_PREF_BASE_URL;


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
    public Setting getSetting() {
        Setting setting = new Setting();
        setting.setBaseUrl(mPrefs.getString(KEY_PREF_BASE_URL, Constants.BASE_URL));
        return setting;
    }

    @Override
    public void saveSetting(Setting setting) {
        SharedPreferences.Editor editor = mPrefs.edit();
        editor.putString(KEY_PREF_BASE_URL, setting.getBaseUrl());
        editor.apply();
    }
}

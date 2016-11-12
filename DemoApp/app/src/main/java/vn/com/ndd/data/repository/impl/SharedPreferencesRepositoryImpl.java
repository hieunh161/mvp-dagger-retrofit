package vn.com.ndd.data.repository.impl;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import rx.Observable;
import rx.Subscriber;
import rx.subjects.PublishSubject;
import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.data.repository.SharedPreferencesRepository;
import vn.com.ndd.utils.Constants;
import vn.com.ndd.utils.SubscriptionUtils;

import static vn.com.ndd.utils.Constants.KEY_PREF_BASE_URL;


/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class SharedPreferencesRepositoryImpl implements SharedPreferencesRepository {
    private SharedPreferences mPrefs;

    protected final PublishSubject<String> mSubject;

    public SharedPreferencesRepositoryImpl(Context context) {
        mPrefs = PreferenceManager.getDefaultSharedPreferences(context);
        mSubject = PublishSubject.create();
    }

    @Override
    public Observable<Setting> getSetting() {
        Setting setting = new Setting();
        setting.setBaseUrl(mPrefs.getString(KEY_PREF_BASE_URL, Constants.BASE_URL));
        return Observable.just(setting);
    }

    @Override
    public Observable<Void> saveSetting(final Setting setting) {
        return Observable.create(new Observable.OnSubscribe<Void>(){
            @Override
            public void call(Subscriber<? super Void> subscriber) {
                SharedPreferences.Editor editor = mPrefs.edit();
                editor.putString(KEY_PREF_BASE_URL, setting.getBaseUrl());
                editor.apply();
                SubscriptionUtils.onNextAndComplete(subscriber);
            }
        });
    }

    /**
     * Gets base url.
     *
     * @return the base url
     */
    @Override
    public Observable<String> getBaseUrl() {
        return Observable.just(mPrefs.getString(KEY_PREF_BASE_URL, Constants.BASE_URL));
    }
}

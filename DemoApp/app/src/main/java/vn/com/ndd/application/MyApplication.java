package vn.com.ndd.application;

import android.app.Application;

import vn.com.ndd.di.component.ApplicationComponent;
import vn.com.ndd.di.component.DaggerApplicationComponent;
import vn.com.ndd.di.module.ApplicationModule;
import vn.com.ndd.di.module.NetworkModule;

/**
 * Created by hieunh on 11/9/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class MyApplication extends Application {

    ApplicationComponent mApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        initializeApplicationComponent();
    }

    protected void initializeApplicationComponent() {
        mApplicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(getApplicationContext()))
                .networkModule(new NetworkModule())
                .build();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public ApplicationComponent getApplicationComponent(){
        return mApplicationComponent;
    }
}

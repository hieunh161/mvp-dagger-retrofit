package vn.com.ndd.application;

import vn.com.ndd.di.component.ApplicationComponent;
import vn.com.ndd.di.component.DaggerMockApplicationComponent;
import vn.com.ndd.di.component.MockApplicationComponent;
import vn.com.ndd.di.module.MockApplicationModule;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class MockMyApplication extends MyApplication{
    MockApplicationComponent component;

    @Override public void onCreate() {
        super.onCreate();
        component = DaggerMockApplicationComponent.builder()
                .mockApplicationModule(new MockApplicationModule(this))
                .build();
    }

    @Override public ApplicationComponent getApplicationComponent() {
        return component;
    }

}

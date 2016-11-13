package vn.com.ndd.application;

import javax.inject.Singleton;

import dagger.Component;
import vn.com.ndd.di.component.ApplicationComponent;
import vn.com.ndd.di.module.ApplicationTestModule;
import vn.com.ndd.presentation.activity.LoginActivity;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class MyTestApplication extends MyApplication{
    @Singleton
    @Component(modules = {ApplicationTestModule.class})
    public interface TestApplicationComponent extends ApplicationComponent {
        void inject(LoginActivity loginActivity);
    }

    private ApplicationComponent component;

    @Override
    protected void initializeApplicationComponent() {
        component = DaggerMyTestApplication_TestApplicationComponent.builder()
                .applicationTestModule(new ApplicationTestModule(getApplicationContext()))
                .build();
    }

    public ApplicationComponent component() {
        return component;
    }

}

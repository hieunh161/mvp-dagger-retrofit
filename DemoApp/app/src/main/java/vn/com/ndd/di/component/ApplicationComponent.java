package vn.com.ndd.di.component;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;
import vn.com.ndd.di.module.ApplicationModule;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {
    // void inject(MyApplication application);
    // Any dependency you want to provide to the child scopes,
    // we need to expose them via the parent component's interface.
    Retrofit exposeRetrofit();
    Context exposeContext();
}

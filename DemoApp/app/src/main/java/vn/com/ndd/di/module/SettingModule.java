package vn.com.ndd.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import vn.com.ndd.data.repository.SharedPreferencesRepository;
import vn.com.ndd.data.repository.impl.SharedPreferencesRepositoryImpl;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.presentation.view.SettingView;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

@Module
public class SettingModule {
    SettingView mView;

    public SettingModule(SettingView view){
        this.mView = view;
    }

    @ActivityScope
    @Provides
    SharedPreferencesRepository provideSharePreferenceRepository(Context context){
        return new SharedPreferencesRepositoryImpl(context);
    }

    @ActivityScope
    @Provides
    SettingView provideLoginView(){
        return mView;
    }
}

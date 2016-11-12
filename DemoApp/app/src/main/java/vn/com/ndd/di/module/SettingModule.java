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
    /**
     * The M view.
     */
    SettingView mView;

    /**
     * Instantiates a new Setting module.
     *
     * @param view the view
     */
    public SettingModule(SettingView view){
        this.mView = view;
    }

    /**
     * Provide share preference repository shared preferences repository.
     *
     * @param context the context
     * @return the shared preferences repository
     */
    @ActivityScope
    @Provides
    SharedPreferencesRepository provideSharePreferenceRepository(Context context){
        return new SharedPreferencesRepositoryImpl(context);
    }

    /**
     * Provide login view setting view.
     *
     * @return the setting view
     */
    @ActivityScope
    @Provides
    SettingView provideLoginView(){
        return mView;
    }
}

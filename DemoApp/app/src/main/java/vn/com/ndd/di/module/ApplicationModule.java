package vn.com.ndd.di.module;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class ApplicationModule {

    private Context mContext;

    /**
     * Instantiates a new Application module.
     *
     * @param context the context
     */
    public ApplicationModule(Context context){
       this.mContext = context;
    }

    /**
     * Provide context context.
     *
     * @return the context
     */
    @Singleton
    @Provides
    Context provideContext(){
        return mContext;
    }
}

package vn.com.ndd.di.module;

import android.content.Context;

import dagger.Module;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class ApplicationTestModule extends ApplicationModule {

    private Context mContext;

    /**
     * Instantiates a new Application module.
     *
     * @param context the context
     */
    public ApplicationTestModule(Context context){
        super(context);
        this.mContext = context;
    }
}

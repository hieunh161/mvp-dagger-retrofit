package vn.com.ndd.di.module;

import android.content.Context;

import org.mockito.Mockito;

import dagger.Module;
import retrofit2.Retrofit;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class MockApplicationModule extends ApplicationModule {

    private Context mContext;

    /**
     * Instantiates a new Application module.
     *
     * @param context the context
     */
    public MockApplicationModule(Context context){
        super(context);
        this.mContext = context;
    }

    Retrofit provideRetrofit() {
        Retrofit mockRetrofit = Mockito.mock(Retrofit.class);
        return mockRetrofit;
    }
}

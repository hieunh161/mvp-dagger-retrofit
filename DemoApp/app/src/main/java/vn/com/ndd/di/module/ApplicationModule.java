package vn.com.ndd.di.module;

import android.content.Context;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.com.ndd.utils.Constant;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

@Module
public class ApplicationModule {

    private Context mContext;

    public ApplicationModule(Context context){
       this.mContext = context;
    }

    @Singleton
    @Provides
    GsonConverterFactory provideGsonCoverterFactory(){
        return GsonConverterFactory.create();
    }

    @Singleton
    @Provides
    @Named("default-timeout")
    OkHttpClient provideHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    @Singleton
    @Provides
    @Named("specific-timeout")
    OkHttpClient provideHttpClientWithTimeout(){
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory converterFactory,
                             RxJavaCallAdapterFactory adapterFactory,
                             @Named("default-timeout") OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(Constant.BASE_URL)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)  // custom client
                .build();
    }

    @Singleton
    @Provides
    Context provideContext(){
        return mContext;
    }
}

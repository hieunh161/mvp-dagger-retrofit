package vn.com.ndd.di.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hieunh on 11/16/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class NetworkModule {

    /**
     * The Base url.
     */
    String baseUrl;

    /**
     * Instantiates a new Network module.
     *
     * @param baseUrl the base url
     */
    public NetworkModule(String baseUrl){
        this.baseUrl = baseUrl;
    }

    /**
     * Provide gson coverter factory gson converter factory.
     *
     * @return the gson converter factory
     */
    @Singleton
    @Provides
    GsonConverterFactory provideGsonCoverterFactory(){
        return GsonConverterFactory.create();
    }

    /**
     * Provide http client ok http client.
     *
     * @return the ok http client
     */
    @Singleton
    @Provides
    @Named("default-timeout")
    OkHttpClient provideHttpClient(){
        return new OkHttpClient.Builder().build();
    }

    /**
     * Provide http client with timeout ok http client.
     *
     * @return the ok http client
     */
    @Singleton
    @Provides
    @Named("specific-timeout")
    OkHttpClient provideHttpClientWithTimeout(){
        return new OkHttpClient.Builder()
                .connectTimeout(30, TimeUnit.SECONDS)
                .build();
    }

    /**
     * Provide rx java call adapter factory rx java call adapter factory.
     *
     * @return the rx java call adapter factory
     */
    @Singleton
    @Provides
    RxJavaCallAdapterFactory provideRxJavaCallAdapterFactory(){
        return RxJavaCallAdapterFactory.create();
    }

    // TODO: need decision on design
    /**
     * Provides shared preferences shared preferences.
     *
     * @param application the application
     * @return the shared preferences
     */
    @Provides
    @Singleton
    SharedPreferences providesSharedPreferences(Application application) {
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    /**
     * Provide retrofit retrofit.
     *
     * @param converterFactory the converter factory
     * @param adapterFactory   the adapter factory
     * @param client           the client
     * @return the retrofit
     */
    @Singleton
    @Provides
    Retrofit provideRetrofit(GsonConverterFactory converterFactory,
                             RxJavaCallAdapterFactory adapterFactory,
                             @Named("default-timeout") OkHttpClient client){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)  // custom client
                .build();
    }
}

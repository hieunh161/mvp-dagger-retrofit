package vn.com.ndd.di.module;

import java.util.concurrent.TimeUnit;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import vn.com.ndd.common.Constants;

/**
 * Created by hieunh on 11/16/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class NetworkModule {
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
                .baseUrl(Constants.BASE_URL)
                .addConverterFactory(converterFactory)
                .addCallAdapterFactory(adapterFactory)
                .client(client)  // custom client
                .build();
    }
}

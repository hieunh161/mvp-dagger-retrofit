package vn.com.ndd.di.module;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vn.com.ndd.data.rest.LoginApiService;
import vn.com.ndd.di.scope.ActivityScope;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

@Module
public class LoginMockModule {
    @Provides
    @ActivityScope
    @Named("MockService")
    LoginApiService provideLoginApiService(Retrofit retrofit){
        return new Retrofit.Builder()
                .baseUrl("http://mock.url")
                .build()
                .create(LoginApiService.class);
    }
}

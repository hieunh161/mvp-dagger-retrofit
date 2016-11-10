package vn.com.ndd.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vn.com.ndd.api.login.LoginApiService;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.mvp.view.LoginView;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

@Module
public class LoginModule {

    LoginView mView;

    public LoginModule(LoginView view){
        this.mView = view;
    }

    @ActivityScope
    @Provides
    LoginApiService getLoginApiService(Retrofit retrofit){
        return retrofit.create(LoginApiService.class);
    }

    @ActivityScope
    @Provides
    LoginView provideLoginView(){
        return mView;
    }
}

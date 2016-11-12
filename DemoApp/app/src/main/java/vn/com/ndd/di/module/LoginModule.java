package vn.com.ndd.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vn.com.ndd.data.rest.LoginApiService;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.presentation.view.LoginView;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class LoginModule {

    /**
     * The M view.
     */
    LoginView mView;

    /**
     * Instantiates a new Login module.
     *
     * @param view the view
     */
    public LoginModule(LoginView view){
        this.mView = view;
    }

    /**
     * Get login api service login api service.
     *
     * @param retrofit the retrofit
     * @return the login api service
     */
    @ActivityScope
    @Provides
    LoginApiService getLoginApiService(Retrofit retrofit){
        return retrofit.create(LoginApiService.class);
    }

    /**
     * Provide login view login view.
     *
     * @return the login view
     */
    @ActivityScope
    @Provides
    LoginView provideLoginView(){
        return mView;
    }
}

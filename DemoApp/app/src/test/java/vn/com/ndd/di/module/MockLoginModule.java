package vn.com.ndd.di.module;

import dagger.Module;
import vn.com.ndd.presentation.view.LoginView;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

@Module
public class MockLoginModule extends LoginModule{

    /**
     * Instantiates a new Login module.
     *
     * @param view the view
     */
    public MockLoginModule(LoginView view) {
        super(view);
    }

//    @Override
//    @ActivityScope
//    LoginApiService providePhotoApiSrvice(Retrofit retrofit){
//        final NetworkBehavior behavior = NetworkBehavior.create();
//        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
//                .networkBehavior(behavior).build();
//        final BehaviorDelegate<LoginApiService> delegate = mockRetrofit.create(LoginApiService.class);
//        return new MockLoginApiService(delegate);
//    }
}

package vn.com.ndd.di.component;

import dagger.Component;
import vn.com.ndd.di.module.LoginModule;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.presentation.view.fragment.LoginFragment;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@ActivityScope
@Component(modules = LoginModule.class, dependencies = ApplicationComponent.class)
public interface LoginComponent {
    void inject(LoginFragment fragment);
}

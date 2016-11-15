package vn.com.ndd.di.component;

import dagger.Component;
import vn.com.ndd.di.module.MockLoginModule;
import vn.com.ndd.di.scope.ActivityScope;

/**
 * Created by hieunh on 11/15/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@ActivityScope
@Component(modules = MockLoginModule.class, dependencies = MockApplicationComponent.class)
public interface MockLoginComponent extends LoginComponent{
}

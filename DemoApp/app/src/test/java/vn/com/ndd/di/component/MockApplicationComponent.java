package vn.com.ndd.di.component;

import javax.inject.Singleton;

import dagger.Component;
import vn.com.ndd.di.module.MockApplicationModule;
import vn.com.ndd.di.module.MockNetworkModule;

/**
 * Created by hieunh on 11/15/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

@Singleton
@Component(modules = { MockApplicationModule.class, MockNetworkModule.class})
public interface MockApplicationComponent extends ApplicationComponent {
}

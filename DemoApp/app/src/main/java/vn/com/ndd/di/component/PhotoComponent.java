package vn.com.ndd.di.component;

import dagger.Component;
import vn.com.ndd.di.module.PhotoModule;
import vn.com.ndd.di.scope.ActivityScope;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@ActivityScope
@Component(modules = PhotoModule.class, dependencies = ApplicationComponent.class)
public interface PhotoComponent {
}

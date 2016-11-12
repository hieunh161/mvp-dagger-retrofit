package vn.com.ndd.di.component;

import dagger.Component;
import vn.com.ndd.di.module.PhotoListModule;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.presentation.view.fragment.PhotoListFragment;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@ActivityScope
@Component(modules = PhotoListModule.class, dependencies = ApplicationComponent.class)
public interface PhotoListComponent {
    void inject(PhotoListFragment fragment);
}

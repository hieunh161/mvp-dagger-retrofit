package vn.com.ndd.di.component;

import dagger.Component;
import vn.com.ndd.di.module.SettingModule;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.presentation.view.fragment.SettingFragment;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@ActivityScope
@Component(modules = SettingModule.class, dependencies = ApplicationComponent.class)
public interface SettingComponent {
    void inject(SettingFragment fragment);
}

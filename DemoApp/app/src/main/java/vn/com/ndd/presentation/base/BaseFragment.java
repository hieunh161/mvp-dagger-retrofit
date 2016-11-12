package vn.com.ndd.presentation.base;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import vn.com.ndd.application.MyApplication;
import vn.com.ndd.di.component.ApplicationComponent;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public abstract class BaseFragment extends Fragment {

    Unbinder unbinder;

    // get component from activity
//    protected <C> C getComponent(Class<C> componentType){
//        return componentType.cast(((HasComponent<C>) getActivity()).getComponent());
//    }

    protected abstract int getContentView();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(getContentView(), container, false);
        // resolve dependencies
        resolveDependencies();
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    protected void resolveDependencies() {
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getActivity().getApplication()).getApplicationComponent();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

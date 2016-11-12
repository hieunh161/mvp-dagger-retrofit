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

    /**
     * The Unbinder.
     */
    Unbinder unbinder;

    /**
     * Gets content view.
     *
     * @return the content view
     */
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

    /**
     * Resolve dependencies to inject to view
     */
    protected void resolveDependencies() {
        // this content will be override by child class
    }

    /**
     * Gets application component.
     *
     * @return the application component
     */
    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getActivity().getApplication()).getApplicationComponent();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}

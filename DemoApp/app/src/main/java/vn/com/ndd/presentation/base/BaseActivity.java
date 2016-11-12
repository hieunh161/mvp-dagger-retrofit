package vn.com.ndd.presentation.base;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import vn.com.ndd.R;

/**
 * Created by hieunh on 11/9/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {

    protected abstract Fragment getFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_layout);
        initializeActivity(savedInstanceState);

    }

    private void initializeActivity(Bundle savedInstanceState) {
        if (savedInstanceState == null) {
            addFragment(R.id.fragmentContainer, getFragment());
        }
    }

    /**
     * Adds a {@link Fragment} to this activity's layout.
     *
     * @param containerViewId The container view to where add the fragment.
     * @param fragment The fragment to be added.
     */
    protected void addFragment(int containerViewId, Fragment fragment) {
        FragmentTransaction fragmentTransaction = this.getFragmentManager().beginTransaction();
        fragmentTransaction.add(containerViewId, fragment);
        fragmentTransaction.commit();
    }
}

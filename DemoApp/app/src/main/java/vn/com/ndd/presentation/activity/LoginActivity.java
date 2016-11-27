package vn.com.ndd.presentation.activity;

import android.app.Fragment;

import vn.com.ndd.presentation.view.fragment.LoginFragment;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class LoginActivity extends SecuredActivity {

    @Override
    protected Fragment getFragment() {
        return new LoginFragment();
    }
}

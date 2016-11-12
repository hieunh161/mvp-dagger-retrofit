package vn.com.ndd.presentation.activity;

import android.app.Fragment;

import vn.com.ndd.presentation.base.BaseActivity;
import vn.com.ndd.presentation.view.fragment.PhotoListFragment;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class PhotoListActivity extends BaseActivity {

    @Override
    protected Fragment getFragment() {
        return new PhotoListFragment();
    }
}

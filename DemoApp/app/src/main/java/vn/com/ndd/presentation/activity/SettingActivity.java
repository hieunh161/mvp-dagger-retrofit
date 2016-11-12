package vn.com.ndd.presentation.activity;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;

import vn.com.ndd.presentation.base.BaseActivity;
import vn.com.ndd.presentation.view.fragment.SettingFragment;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class SettingActivity extends BaseActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // set back button on actionBar
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected Fragment getFragment() {
        return new SettingFragment();
    }
}

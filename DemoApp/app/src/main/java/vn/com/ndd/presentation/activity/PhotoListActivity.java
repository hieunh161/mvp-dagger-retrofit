package vn.com.ndd.presentation.activity;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.view.Menu;
import android.view.MenuItem;

import vn.com.ndd.R;
import vn.com.ndd.presentation.base.BaseActivity;
import vn.com.ndd.presentation.view.fragment.PhotoListFragment;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class PhotoListActivity extends BaseActivity {

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
    protected Fragment getFragment() {
        return new PhotoListFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.setting, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_setting:
                navigateToSetting();
                break;
            case android.R.id.home:
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void navigateToSetting() {
        Intent intent = new Intent(this, SettingActivity.class);
        startActivity(intent);
    }

}

package vn.com.ndd.module.main;

import android.content.Intent;
import android.os.Bundle;

import vn.com.ndd.R;
import vn.com.ndd.base.BaseActivity;

public class MainActivity extends BaseActivity {
    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onViewReady(Bundle savedInstanceState, Intent intent){
        super.onViewReady(savedInstanceState, intent);
    }
}

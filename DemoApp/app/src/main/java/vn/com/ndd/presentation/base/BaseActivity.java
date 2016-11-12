package vn.com.ndd.presentation.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.v7.app.AppCompatActivity;

import vn.com.ndd.application.MyApplication;
import vn.com.ndd.di.component.ApplicationComponent;

/**
 * Created by hieunh on 11/9/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public abstract class BaseActivity extends AppCompatActivity {
    protected abstract int getContentView();

    @CallSuper
    protected void onViewReady(Bundle savedInstanceState, Intent intent){
        // to be used on child activity
        resolveDependencies();
    }

    protected void resolveDependencies() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getContentView());
        onViewReady(savedInstanceState, getIntent());
    }

    protected ApplicationComponent getApplicationComponent() {
        return ((MyApplication)getApplication()).getApplicationComponent();
    }
}

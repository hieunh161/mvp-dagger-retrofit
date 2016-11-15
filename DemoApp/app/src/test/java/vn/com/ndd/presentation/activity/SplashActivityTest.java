package vn.com.ndd.presentation.activity;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowLooper;

import vn.com.ndd.BuildConfig;
import vn.com.ndd.application.MockMyApplication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by hieunh on 11/16/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = MockMyApplication.class)
public class SplashActivityTest {
    @Test
    public void shouldInitViewAfterRun(){
        SplashActivity activity = Robolectric.setupActivity(SplashActivity.class);
        assertThat(activity, notNullValue());
        assertThat(activity.isFinishing(), is(false));
        ShadowLooper.runUiThreadTasksIncludingDelayedTasks();
        assertThat(activity.isFinishing(), is(true));
    }
}

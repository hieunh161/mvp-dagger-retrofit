package vn.com.ndd.presentation.activity;

import android.view.MenuItem;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.fakes.RoboMenuItem;
import org.robolectric.shadows.ShadowActivity;

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
public class SettingActivityTest {
    private SettingActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(SettingActivity.class);
    }

    @After
    public void tearDown() throws Exception {
        // relese resource
        activity = null;
    }

    @Test
    public void shouldInitViewAfterRun(){
        assertThat(activity, notNullValue());
    }

    @Test
    public void shouldFinishWhenClickHome(){
        MenuItem menuItem = new RoboMenuItem(android.R.id.home);
        activity.onOptionsItemSelected(menuItem);
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        assertThat(shadowActivity.isFinishing(), is(true));
    }
}

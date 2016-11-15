package vn.com.ndd.presentation.activity;

import android.content.Intent;
import android.view.MenuItem;
import android.widget.TextView;

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
import vn.com.ndd.R;
import vn.com.ndd.application.MockMyApplication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = MockMyApplication.class)
public class PhotoListActivityTest {
    private PhotoListActivity photoListActivity;

    @Before
    public void setUp() throws Exception {
        photoListActivity = Robolectric.setupActivity(PhotoListActivity.class);
    }

    @After
    public void tearDown() throws Exception {
        // relese resource
        photoListActivity = null;
    }

    @Test
    public void shouldInitViewAfterRun(){
        TextView view = (TextView)photoListActivity.findViewById(R.id.text_photo_list_title);
        assertThat(photoListActivity.getString(R.string.label_photo_list_title), is(view.getText().toString()));
    }

    @Test
    public void shouldNavigateToSettingWhenClickSetting(){
        MenuItem menuItem = new RoboMenuItem(R.id.menu_setting);
        photoListActivity.onOptionsItemSelected(menuItem);
        ShadowActivity shadowActivity = Shadows.shadowOf(photoListActivity);
        Intent expectedIntent = new Intent(photoListActivity, SettingActivity.class);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertThat(expectedIntent.filterEquals(actualIntent), is(true));
    }

    @Test
    public void shouldFinishWhenClickHome(){
        MenuItem menuItem = new RoboMenuItem(android.R.id.home);
        photoListActivity.onOptionsItemSelected(menuItem);
        ShadowActivity shadowActivity = Shadows.shadowOf(photoListActivity);
        assertThat(shadowActivity.isFinishing(), is(true));
    }
}

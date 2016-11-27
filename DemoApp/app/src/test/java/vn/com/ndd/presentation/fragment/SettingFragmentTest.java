package vn.com.ndd.presentation.fragment;

import android.app.AlertDialog;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.util.FragmentTestUtil;

import vn.com.ndd.BuildConfig;
import vn.com.ndd.R;
import vn.com.ndd.application.MockMyApplication;
import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.presentation.presenter.SettingPresenter;
import vn.com.ndd.presentation.view.fragment.LoginFragment;
import vn.com.ndd.presentation.view.fragment.SettingFragment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.any;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by hieunh on 11/19/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = MockMyApplication.class)
public class SettingFragmentTest {
    SettingFragment fragment;
    @Mock
    SettingPresenter presenter;

    @Before
    public void Setup(){
        MockitoAnnotations.initMocks(this);
        fragment = new SettingFragment();
        FragmentTestUtil.startFragment(fragment);
        presenter = Mockito.spy(new SettingPresenter());
        Mockito.doNothing().when(presenter).saveSetting(any(Setting.class));
        Mockito.doNothing().when(presenter).destroy();
        fragment.setPresenter(presenter);
    }

    @Test
    public void shouldShowDialog(){
//        fragment.showProgressDialog(R.string.message_authenticating);
//        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
//        assertThat(alert.isShowing(), equalTo(true));
//        assertThat(((String) shadowOf(alert).getTitle()), equalTo(""));
//        assertThat(((String) shadowOf(alert).getMessage()), equalTo("Authenticating..."));
//        assertThat(alert.getButton(AlertDialog.BUTTON_POSITIVE), notNullValue());
    }

    @Test
    public void shouldHideAfterShowDialog(){
//        fragment.showProgressDialog(R.string.message_authenticating);
//        fragment.hideProgressDialog();
//        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
//        assertThat(alert.isShowing(), equalTo(false));
    }
}

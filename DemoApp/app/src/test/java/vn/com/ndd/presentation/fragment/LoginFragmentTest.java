package vn.com.ndd.presentation.fragment;

import android.app.AlertDialog;
import android.content.Intent;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowAlertDialog;
import org.robolectric.util.FragmentTestUtil;

import vn.com.ndd.BuildConfig;
import vn.com.ndd.R;
import vn.com.ndd.application.MockMyApplication;
import vn.com.ndd.presentation.view.activity.PhotoListActivity;
import vn.com.ndd.presentation.presenter.LoginPresenter;
import vn.com.ndd.presentation.view.fragment.LoginFragment;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.robolectric.Shadows.shadowOf;

/**
 * Created by hieunh on 11/16/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = MockMyApplication.class)
public class LoginFragmentTest {
    LoginFragment fragment;
    @Mock
    LoginPresenter presenter;

    @Before
    public void Setup(){
        MockitoAnnotations.initMocks(this);
        fragment = new LoginFragment();
        FragmentTestUtil.startFragment(fragment);
        presenter = Mockito.spy(new LoginPresenter());
        Mockito.doNothing().when(presenter).authenticate(anyString(), anyString());
        Mockito.doNothing().when(presenter).destroy();
        fragment.setPresenter(presenter);
    }

    @After
    public void TearDown(){
        fragment = null;
    }

    @Test
    public void shouldBeNotNull(){
        assertThat(fragment, notNullValue());
    }

    @Test
    public void shouldShowDialog(){
        fragment.showProgressDialog(R.string.message_authenticating);
        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
        assertThat(alert.isShowing(), equalTo(true));
        assertThat(((String) shadowOf(alert).getTitle()), equalTo(""));
        assertThat(((String) shadowOf(alert).getMessage()), equalTo("Authenticating..."));
        assertThat(alert.getButton(AlertDialog.BUTTON_POSITIVE), notNullValue());
    }

    @Test
    public void shouldHideAfterShowDialog(){
        fragment.showProgressDialog(R.string.message_authenticating);
        fragment.dismissProgressDialog();
        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
        assertThat(alert.isShowing(), equalTo(false));
    }

    @Test
    public void shouldShowErrorDialog(){
        fragment.showErrorDialog(R.string.dialog_title_error, R.string.dialog_message_network_not_available);
        AlertDialog alert = ShadowAlertDialog.getLatestAlertDialog();
//        assertThat(alert.isShowing(), equalTo(true));
//        assertThat(((String) shadowOf(alert).getTitle()), equalTo("Error"));
//        assertThat(((String) shadowOf(alert).getMessage()), equalTo("Network is not available"));
    }

    @Test
    public void shouldReturnAfterAuthenticate(){
        fragment.onButtonLoginClicked();
        // verify that presenter.authenticate is called
        verify(presenter, times(1)).authenticate("", "");
    }

    @Test
    public void shouldNavigateToMainScreen(){
        fragment.navigateToMain();
        ShadowActivity shadowActivity = Shadows.shadowOf(fragment.getActivity());
        Intent expectedIntent = new Intent(fragment.getActivity(), PhotoListActivity.class);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
        assertThat(expectedIntent.filterEquals(actualIntent), is(true));
    }

    @Test
    public void shouldCallPresenterDestroyOnDestroy(){
        fragment.onDestroy();
        verify(presenter, times(1)).destroy();
    }
}

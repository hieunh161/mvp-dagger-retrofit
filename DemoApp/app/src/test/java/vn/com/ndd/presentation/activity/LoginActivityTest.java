package vn.com.ndd.presentation.activity;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import vn.com.ndd.BuildConfig;
import vn.com.ndd.application.MockMyApplication;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.notNullValue;

/**
 * Created by hieunh on 11/14/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@RunWith(RobolectricTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23, application = MockMyApplication.class)
public class LoginActivityTest {
    private LoginActivity loginActivity;

//    private LoginApiService buildMockApiService(Retrofit retrofit){
//        final NetworkBehavior behavior = NetworkBehavior.create();
//        MockRetrofit mockRetrofit = new MockRetrofit.Builder(retrofit)
//                .networkBehavior(behavior).build();
//        final BehaviorDelegate<LoginApiService> delegate = mockRetrofit.create(LoginApiService.class);
//        return new MockLoginApiService(delegate);
//    }
    @Before
    public void setUp() throws Exception {
        loginActivity = Robolectric.setupActivity(LoginActivity.class);
    }

    @After
    public void tearDown() throws Exception {
        // relese resource
        loginActivity = null;
    }

    @Test
    public void shouldInitViewAfterRun(){
        assertThat(loginActivity, notNullValue());
    }
}

package vn.com.ndd.data.rest;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;
import vn.com.ndd.data.entity.LoginResponse;
import vn.com.ndd.domain.interactor.LoginUseCase;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class LoginApiServiceTest {
    private static final String USER = "USERNAME";
    LoginApiService interactor;

    @Before
    public void setUp() {
        //interactor = new ProfileInteractorImpl(...);
    }

    @Test
    public void testUsingTestSubscriber() throws Exception {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        Observable.just(1).subscribe(testSubscriber);
        testSubscriber.assertNoErrors();
        testSubscriber.assertReceivedOnNext(Arrays.asList(1));
    }

    @Test
    public void testUsingTestSchedulers() throws Exception {
        TestScheduler scheduler = new TestScheduler();
        TestSubscriber<Long> testSubscriber = new TestSubscriber<>();
        Observable.interval(1, TimeUnit.SECONDS, scheduler).take(5).observeOn(scheduler).subscribeOn(scheduler).subscribe(testSubscriber);
        testSubscriber.assertNoValues();
        scheduler.advanceTimeBy(2, TimeUnit.SECONDS);
        testSubscriber.assertReceivedOnNext(Arrays.asList(0L, 1L));
        scheduler.advanceTimeBy(10, TimeUnit.SECONDS);
        testSubscriber.assertCompleted();
    }

    @Test
    public void testGetCountriesObservable_FiltersOutAtlantis() throws Exception {
        LoginResponse loginResponse = new LoginResponse();
        loginResponse.setStatus("OK");
        loginResponse.setAuthenCode("authenCode");
        LoginUseCase loginUseCase = new LoginUseCase();
        TestSubscriber<String> testSubscriber = new TestSubscriber<>();
    }

    @Test
    public void testGetUserProfile() throws Exception {

    }
}

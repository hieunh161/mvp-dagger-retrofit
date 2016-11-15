package vn.com.ndd.data.rest;

import retrofit2.http.Body;
import retrofit2.mock.BehaviorDelegate;
import rx.Observable;
import vn.com.ndd.data.entity.LoginAccount;
import vn.com.ndd.data.entity.LoginResponse;

/**
 * Created by hieunh on 11/15/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class MockLoginApiService implements LoginApiService {
    private final BehaviorDelegate<LoginApiService> mDelegate;

    public MockLoginApiService(BehaviorDelegate<LoginApiService> delegate) {
        this.mDelegate = delegate;
    }

    @Override
    public Observable<LoginResponse> authenticate(@Body LoginAccount account) {
        LoginResponse mockResponse = new LoginResponse();
        mockResponse.setAuthenCode("1234");
        mockResponse.setStatus("OK");
        return mDelegate.returningResponse(mockResponse).authenticate(account);
    }
}

package vn.com.ndd.mvp.presenter;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import vn.com.ndd.R;
import vn.com.ndd.api.login.LoginAccount;
import vn.com.ndd.api.login.LoginApiService;
import vn.com.ndd.api.login.LoginResponse;
import vn.com.ndd.base.BasePresenter;
import vn.com.ndd.mapper.LoginMapper;
import vn.com.ndd.mvp.model.LoginStatus;
import vn.com.ndd.mvp.view.LoginView;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class LoginPresenter extends BasePresenter<LoginView> implements Observer<LoginResponse> {
    @Inject
    LoginApiService mLoginApiService;

    @Inject
    LoginMapper mMapper;

    @Inject
    Context context;

    @Inject
    public LoginPresenter(){}

    public void authenticate(String username, String password) {
        Log.d("LoginPresenter","login running"+username + password);
        getView().showProgressDialog(context.getString(R.string.message_authenticating));
        Observable<LoginResponse> observable = mLoginApiService.authenticate(new LoginAccount(username, password));
        subscribe(observable, this);
    }

    /**
     * Notifies the Observer that the {@link Observable} has finished sending push-based notifications.
     * <p>
     * The {@link Observable} will not call this method if it calls {@link #onError}.
     */
    @Override
    public void onCompleted() {
        Log.d("LoginPresenter","onCompleted");
        getView().hideProgressDialog();
    }

    /**
     * Notifies the Observer that the {@link Observable} has experienced an error condition.
     * <p>
     * If the {@link Observable} calls this method, it will not thereafter call {@link #onNext} or
     * {@link #onCompleted}.
     *
     * @param e the exception encountered by the Observable
     */
    @Override
    public void onError(Throwable e) {
        Log.d("LoginPresenter","onError " + e.toString());
        getView().hideProgressDialog();
    }

    /**
     * Provides the Observer with a new item to observe.
     * <p>
     * The {@link Observable} may call this method 0 or more times.
     * <p>
     * The {@code Observable} will not call this method again after it calls either {@link #onCompleted} or
     * {@link #onError}.
     *
     * @param loginResponse the item emitted by the Observable
     */
    @Override
    public void onNext(LoginResponse loginResponse) {
        Log.d("LoginPresenter","onError " + loginResponse.getStatus());
        LoginStatus loginStatus = mMapper.mapLoginResponse(loginResponse);
        if(loginStatus.isSuccess()){
            getView().navigateToMain();
        }
    }
}

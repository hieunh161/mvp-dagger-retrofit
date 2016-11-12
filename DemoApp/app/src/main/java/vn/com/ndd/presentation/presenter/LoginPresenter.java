package vn.com.ndd.presentation.presenter;

import android.content.Context;
import android.util.Log;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import vn.com.ndd.R;
import vn.com.ndd.data.entity.LoginAccount;
import vn.com.ndd.data.entity.LoginResponse;
import vn.com.ndd.domain.interactor.LoginUseCase;
import vn.com.ndd.mapper.LoginMapper;
import vn.com.ndd.presentation.base.BasePresenter;
import vn.com.ndd.presentation.model.LoginStatus;
import vn.com.ndd.presentation.view.LoginView;
import vn.com.ndd.utils.NetworkUtils;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class LoginPresenter extends BasePresenter<LoginView> implements Observer<LoginResponse> {
    @Inject
    LoginUseCase mLoginUseCase;

    /**
     * The M mapper.
     */
    @Inject
    LoginMapper mMapper;

    /**
     * The Context.
     */
    @Inject
    Context context;

    /**
     * Instantiates a new Login presenter.
     */
    @Inject
    public LoginPresenter(){}

    /**
     * Authenticate.
     *
     * @param username the username
     * @param password the password
     */
    public void authenticate(String username, String password) {
        if(!NetworkUtils.isNetworkAvailable(context)){
            getView().showDialogLoginError(R.string.dialog_title_error, R.string.dialog_message_network_not_available);
            return;
        }
        Log.d("LoginPresenter","login running"+ username + password);
        getView().showProgressDialog(context.getString(R.string.message_authenticating));
        // pass login account to use case in domain layer
        mLoginUseCase.setAccount(new LoginAccount(username, password));
        mLoginUseCase.subscribe(this);
    }

    /**
     * Notifies the Observer that the {@link Observable} has finished sending push-based notifications.
     * <p>
     * The {@link Observable} will not call this method if it calls {@link #onError}.
     */
    @Override
    public void onCompleted() {
        Log.d("LoginPresenter","onCompleted");
        // getView().hideProgressDialog();
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
        // show error dialog
        getView().showDialogLoginError(R.string.dialog_title_error, R.string.dialog_message_login_fail);
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
        getView().hideProgressDialog();
        if(loginStatus.isSuccess()){
            getView().navigateToMain();
        } else {
            getView().showDialogLoginError(R.string.dialog_title_error, R.string.dialog_message_login_fail);
        }
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    @Override
    public void destroy() {
        mLoginUseCase.unsubscribe();
    }
}

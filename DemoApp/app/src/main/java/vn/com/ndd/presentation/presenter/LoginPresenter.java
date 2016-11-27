package vn.com.ndd.presentation.presenter;

import android.util.Log;

import javax.inject.Inject;

import rx.Observer;
import vn.com.ndd.R;
import vn.com.ndd.data.entity.LoginAccount;
import vn.com.ndd.data.entity.LoginResponse;
import vn.com.ndd.domain.interactor.LoginUseCase;
import vn.com.ndd.presentation.base.BasePresenter;
import vn.com.ndd.presentation.mapper.LoginMapper;
import vn.com.ndd.presentation.model.LoginStatus;
import vn.com.ndd.presentation.view.LoginView;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class LoginPresenter extends BasePresenter<LoginView> {
    /**
     * The M login use case.
     */
    @Inject
    LoginUseCase mUseCase;

    /**
     * The M mapper.
     */
    @Inject
    LoginMapper mMapper;

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
        Log.d("LoginPresenter","login running"+ username + password);
        getView().showProgressDialog(R.string.message_authenticating);
        // pass login account to use case in domain layer
        mUseCase.setLoginObservable(new LoginAccount(username, password));
        mUseCase.subscribe(loginObserver);
    }


    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    @Override
    public void destroy() {
        mUseCase.unsubscribe();
    }

    /**
     * The Login observer.
     */
    Observer<LoginResponse> loginObserver = new Observer<LoginResponse>() {
        @Override
        public void onCompleted() {
            Log.d("LoginPresenter","onCompleted");
        }

        @Override
        public void onError(Throwable e) {
            Log.d("LoginPresenter","onError " + e.toString());
            getView().dismissProgressDialog();
            // show error dialog
            getView().showErrorDialog(R.string.dialog_title_error, R.string.dialog_message_login_fail);
        }

        @Override
        public void onNext(LoginResponse loginResponse) {
            Log.d("LoginPresenter","onError " + loginResponse.getStatus());
            LoginStatus loginStatus = mMapper.mapLoginResponse(loginResponse);
            getView().dismissProgressDialog();
            if(loginStatus.isSuccess()){
                getView().navigateToMain();
            } else {
                getView().showErrorDialog(R.string.dialog_title_error, R.string.dialog_message_login_fail);
            }
        }
    };
}

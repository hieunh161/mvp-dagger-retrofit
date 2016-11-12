package vn.com.ndd.domain.interactor;

import javax.inject.Inject;

import rx.Observable;
import vn.com.ndd.data.entity.LoginAccount;
import vn.com.ndd.data.rest.LoginApiService;


/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class LoginUseCase extends UseCase{
    /**
     * The M login api service.
     */
    @Inject
    LoginApiService mLoginApiService;

    private LoginAccount account;

    @Inject
    public LoginUseCase() {
    }

    /**
     * Build use case observable observable.
     *
     * @return the observable
     */
    @Override
    protected Observable buildUseCaseObservable() {
        return mLoginApiService.authenticate(account);
    }

    /**
     * Sets account.
     *
     * @param account the account
     */
    public void setAccount(LoginAccount account) {
        this.account = account;
    }
}

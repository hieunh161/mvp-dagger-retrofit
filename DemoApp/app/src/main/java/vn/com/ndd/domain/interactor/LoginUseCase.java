package vn.com.ndd.domain.interactor;

import javax.inject.Inject;

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

    /**
     * Instantiates a new Login use case.
     */
    @Inject
    public LoginUseCase() {
    }

    /**
     * Set login observable.
     *
     * @param account the account
     */
    public void setLoginObservable(LoginAccount account){
        setObservable(mLoginApiService.authenticate(account));
    }
}

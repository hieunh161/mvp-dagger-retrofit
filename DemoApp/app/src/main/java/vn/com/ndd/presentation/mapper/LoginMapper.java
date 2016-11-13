package vn.com.ndd.presentation.mapper;

import javax.inject.Inject;

import vn.com.ndd.data.entity.LoginResponse;
import vn.com.ndd.presentation.model.LoginStatus;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class LoginMapper {
    @Inject
    public LoginMapper(){}

    public LoginStatus mapLoginResponse(LoginResponse loginResponse){
        LoginStatus status = new LoginStatus();
        if(loginResponse.getStatus().equals("OK")){
            status.setSuccess(true);
        }else {
            status.setSuccess(false);
        }
        status.setAuthenCode(loginResponse.getStatus());
        return status;
    }
}

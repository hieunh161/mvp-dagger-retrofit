package vn.com.ndd.presentation.model;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class LoginStatus {
    private boolean mIsSuccess;
    private String  authenCode;

    public boolean isSuccess() {
        return mIsSuccess;
    }

    public void setSuccess(boolean mIsSuccess) {
        this.mIsSuccess = mIsSuccess;
    }

    public String getAuthenCode() {
        return authenCode;
    }

    public void setAuthenCode(String authenCode) {
        this.authenCode = authenCode;
    }
}

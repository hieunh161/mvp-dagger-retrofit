package vn.com.ndd.mvp.view;

import vn.com.ndd.base.BaseView;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface LoginView extends BaseView {
    void showProgressDialog(String message);
    void hideProgressDialog();
    void navigateToMain();
}

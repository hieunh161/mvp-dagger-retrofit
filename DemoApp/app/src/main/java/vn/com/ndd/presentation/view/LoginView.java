package vn.com.ndd.presentation.view;

import vn.com.ndd.presentation.base.BaseView;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public interface LoginView extends BaseView {
    /**
     * Show progress dialog.
     *
     * @param message the message
     */
    void showProgressDialog(String message);

    /**
     * Hide progress dialog.
     */
    void hideProgressDialog();

    void showErrorDialog(int title, int message);

    /**
     * Navigate to main.
     */
    void navigateToMain();
}

package vn.com.ndd.presentation.view;

import vn.com.ndd.presentation.base.BaseView;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface LoadDataView extends BaseView {
    /**
     * Show progress dialog.
     *
     * @param message the message
     */
    void showProgressDialog(String message);

    /**
     * Hide progress dialog.
     */
    void dismissProgressDialog();

    /**
     * Show error dialog.
     *
     * @param title   the title
     * @param message the message
     */
    void showErrorDialog(int title, int message);
}

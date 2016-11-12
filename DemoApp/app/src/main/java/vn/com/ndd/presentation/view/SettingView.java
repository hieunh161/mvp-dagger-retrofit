package vn.com.ndd.presentation.view;

import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.presentation.base.BaseView;

/**
 * Created by hieunh on 11/11/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public interface SettingView extends BaseView {
    /**
     * On setting data ready.
     *
     * @param setting the setting
     */
    void onSettingDataReady(Setting setting);

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
}

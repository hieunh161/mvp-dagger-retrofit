package vn.com.ndd.presentation.view.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import vn.com.ndd.R;
import vn.com.ndd.data.entity.Setting;
import vn.com.ndd.di.component.DaggerSettingComponent;
import vn.com.ndd.di.module.SettingModule;
import vn.com.ndd.presentation.base.BaseFragment;
import vn.com.ndd.presentation.presenter.SettingPresenter;
import vn.com.ndd.presentation.view.SettingView;


/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class SettingFragment extends BaseFragment implements SettingView {

    /**
     * The M presenter.
     */
    SettingPresenter mPresenter;

    /**
     * The M input server address.
     */
    @BindView(R.id.input_server_address)
    EditText mInputServerAddress;

    private ProgressDialog mProgressDialog;

    /**
     * Gets content view.
     *
     * @return the content view
     */
    @Override
    protected int getContentView() {
        return R.layout.fragment_setting;
    }

    @Inject
    public void setPresenter(SettingPresenter presenter){
        this.mPresenter = presenter;
    }

    @Override
    protected void resolveDependencies() {
        DaggerSettingComponent.builder()
                .applicationComponent(getApplicationComponent())
                .settingModule(new SettingModule(this)).build().inject(this);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // get share preference and update GUI
        mPresenter.loadSettingData();
    }

    @Override
    public void onSettingDataReady(Setting setting) {
        mInputServerAddress.setText(setting.getBaseUrl());
    }

    @Override
    public void showProgressDialog(String message) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    @Override
    public void hideProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }

    @OnClick(R.id.button_save_setting)
    public void onSaveSettingButtonClicked(){
        Setting setting = new Setting();
        setting.setBaseUrl(mInputServerAddress.getText().toString());
        mPresenter.saveSetting(setting);
    }

}

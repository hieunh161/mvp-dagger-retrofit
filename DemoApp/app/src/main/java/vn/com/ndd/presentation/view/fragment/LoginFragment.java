package vn.com.ndd.presentation.view.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;
import vn.com.ndd.R;
import vn.com.ndd.di.component.DaggerLoginComponent;
import vn.com.ndd.di.module.LoginModule;
import vn.com.ndd.presentation.view.activity.PhotoListActivity;
import vn.com.ndd.presentation.base.BaseFragment;
import vn.com.ndd.presentation.presenter.LoginPresenter;
import vn.com.ndd.presentation.view.LoginView;

import static vn.com.ndd.common.Preconditions.checkNotNull;


/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class LoginFragment extends BaseFragment implements LoginView{
    @BindView(R.id.input_email)
    EditText mInputEmail;

    @BindView(R.id.input_password)
    EditText mInputPassword;

    LoginPresenter mLoginPresenter;

    @Inject
    public void setPresenter(@NonNull LoginPresenter presenter) {
        this.mLoginPresenter = checkNotNull(presenter);
    }

    private ProgressDialog mProgressDialog;

    @Override
    protected int getContentView() {
        return R.layout.fragment_login;
    }

    /**
     * On button login clicked.
     */
    @OnClick(R.id.btn_login)
    public void onButtonLoginClicked(){
        mLoginPresenter.authenticate(mInputEmail.getText().toString(), mInputPassword.getText().toString());
    }

    @Override
    protected void resolveDependencies() {
        DaggerLoginComponent.builder()
                .applicationComponent(getApplicationComponent())
                .loginModule(new LoginModule(this)).build().inject(this);
    }
    @Override
    public void showProgressDialog(int messageId) {
        if (mProgressDialog == null) {
            mProgressDialog = new ProgressDialog(getActivity());
            mProgressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
            mProgressDialog.setCancelable(true);
        }
        mProgressDialog.setMessage(getActivity().getString(messageId));
        mProgressDialog.show();
    }

    @Override
    public void dismissProgressDialog() {
        if (mProgressDialog != null && mProgressDialog.isShowing()) {
            mProgressDialog.dismiss();
        }
    }
    @Override
    public void showErrorDialog(int title, int message) {
        // 1. Instantiate an AlertDialog.Builder with its constructor
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        // 2. Chain together various setter methods to set the dialog characteristics
        builder.setMessage(message)
                .setTitle(title)
                .setPositiveButton(R.string.btn_ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // close dialog
                        dialogInterface.dismiss();
                    }
                });
        // 3. Get the AlertDialog from create()
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mLoginPresenter.destroy();
    }

    @Override
    public void navigateToMain() {
        Intent intent = new Intent(getActivity(), PhotoListActivity.class);
        startActivity(intent);
    }
}

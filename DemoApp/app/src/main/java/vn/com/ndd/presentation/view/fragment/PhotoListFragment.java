package vn.com.ndd.presentation.view.fragment;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import vn.com.ndd.R;
import vn.com.ndd.di.component.DaggerPhotoListComponent;
import vn.com.ndd.di.module.PhotoListModule;
import vn.com.ndd.presentation.base.BaseFragment;
import vn.com.ndd.presentation.model.Photo;
import vn.com.ndd.presentation.presenter.PhotoListPresenter;
import vn.com.ndd.presentation.view.PhotoListView;
import vn.com.ndd.presentation.view.adapter.PhotoListAdapter;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class PhotoListFragment extends BaseFragment implements PhotoListView {

    private static final String TAG = PhotoListFragment.class.getCanonicalName();
    @BindView(R.id.photo_list)
    RecyclerView mPhotoList;

    @Inject
    PhotoListPresenter mPresenter;

    private ProgressDialog mProgressDialog;
    private PhotoListAdapter mPhotoListAdapter;

    /**
     * Gets content view.
     *
     * @return the content view
     */
    @Override
    protected int getContentView() {
        return R.layout.fragment_photo_list;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initializeListView();
        mPresenter.loadPhotos();
    }

    private void initializeListView() {
        mPhotoList.setHasFixedSize(true);
        mPhotoList.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false));
        mPhotoListAdapter = new PhotoListAdapter(getActivity().getLayoutInflater());
        mPhotoList.setAdapter(mPhotoListAdapter);
    }

    @Override
    protected void resolveDependencies() {
        DaggerPhotoListComponent.builder()
                .applicationComponent(getApplicationComponent())
                .photoListModule(new PhotoListModule(this)).build().inject(this);
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
    public void onPhotoListLoaded(List<Photo> photoList) {
        Log.d(TAG, "onPhotoListLoaded" + photoList.size());
        mPhotoListAdapter.addPhotos(photoList);
        mPhotoListAdapter.notifyDataSetChanged();
    }
}

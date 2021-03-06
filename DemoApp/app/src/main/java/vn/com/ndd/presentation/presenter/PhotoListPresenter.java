package vn.com.ndd.presentation.presenter;

import android.util.Log;

import java.util.List;

import javax.inject.Inject;

import rx.Observer;
import vn.com.ndd.R;
import vn.com.ndd.data.entity.PhotoResponse;
import vn.com.ndd.domain.interactor.PhotoListUseCase;
import vn.com.ndd.presentation.base.BasePresenter;
import vn.com.ndd.presentation.mapper.PhotoMapper;
import vn.com.ndd.presentation.model.Photo;
import vn.com.ndd.presentation.view.PhotoListView;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
public class PhotoListPresenter extends BasePresenter<PhotoListView> {
    private static final String TAG = "PhotoListPresenter";
    /**
     * The use case.
     */
    @Inject
    PhotoListUseCase mUseCase;

    @Inject
    PhotoMapper mMapper;

    private Observer<List<PhotoResponse>> photoListObserver = new Observer<List<PhotoResponse>>() {
        @Override
        public void onCompleted() {
            Log.d(TAG, "Get Photo List completed");
            getView().dismissProgressDialog();
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, "Error in get photo list " + e.toString());
            getView().dismissProgressDialog();
        }

        @Override
        public void onNext(List<PhotoResponse> photoList) {
            getView().dismissProgressDialog();
            List<Photo> photos = mMapper.mapPhotoResponse(photoList);
            getView().onPhotoListLoaded(photos);
        }
    };

    /**
     * Instantiates a new Photo list presenter.
     */
    @Inject
    public PhotoListPresenter() {
    }

    public void loadPhotos() {
        getView().showProgressDialog(R.string.message_authenticating);
        // pass login account to use case in domain layer
        mUseCase.setPhotoListObserver();
        mUseCase.subscribe(photoListObserver);
    }

    @Override
    public void destroy() {
        mUseCase.unsubscribe();
    }
}

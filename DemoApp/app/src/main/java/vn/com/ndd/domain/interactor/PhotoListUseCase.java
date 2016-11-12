package vn.com.ndd.domain.interactor;

import javax.inject.Inject;

import vn.com.ndd.data.rest.PhotoApiService;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class PhotoListUseCase extends UseCase {
    @Inject
    PhotoApiService mPhotoApiService;

    @Inject
    public PhotoListUseCase(){}

    public void setPhotoListObserver(){
        setObservable(mPhotoApiService.getPhotos());
    }
}

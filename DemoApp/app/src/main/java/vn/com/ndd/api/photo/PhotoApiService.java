package vn.com.ndd.api.photo;

import retrofit2.Call;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by hieunh on 11/9/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface PhotoApiService {
    @GET("/photos")
    Observable<PhotoResponse> getPhotos();

    @GET("/photos")
    Call<PhotoResponse> getPhotosWithCall();
}

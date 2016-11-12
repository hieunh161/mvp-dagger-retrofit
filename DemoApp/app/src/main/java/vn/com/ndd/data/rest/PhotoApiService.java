package vn.com.ndd.data.rest;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import rx.Observable;
import vn.com.ndd.data.entity.PhotoResponse;

/**
 * Created by hieunh on 11/9/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface PhotoApiService {
    @Headers({
            "Accept: application/json"
    })
    @GET("/api/photo/list")
    Observable<List<PhotoResponse>> getPhotos();

    @Headers({
            "Accept: application/json"
    })
    @GET("/api/photo/list")
    Call<List<PhotoResponse>> getPhotosWithCall();
}

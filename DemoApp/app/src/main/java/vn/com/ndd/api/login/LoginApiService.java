package vn.com.ndd.api.login;


import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public interface LoginApiService {
    @Headers({
            "Accept: application/json"
    })
    @POST("/api/login")
    Observable<LoginResponse> authenticate(@Body LoginAccount account);
}

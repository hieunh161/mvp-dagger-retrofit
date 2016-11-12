package vn.com.ndd.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vn.com.ndd.data.rest.PhotoApiService;
import vn.com.ndd.di.scope.ActivityScope;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class PhotoModule {

    /**
     * Provide photo api service photo api service.
     *
     * @param retrofit the retrofit
     * @return the photo api service
     */
    @ActivityScope
    @Provides
    PhotoApiService providePhotoApiService(Retrofit retrofit){
        return retrofit.create(PhotoApiService.class);
    }


}

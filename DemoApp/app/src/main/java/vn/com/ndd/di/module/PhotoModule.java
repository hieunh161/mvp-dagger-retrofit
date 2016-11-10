package vn.com.ndd.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vn.com.ndd.api.photo.PhotoApiService;
import vn.com.ndd.di.scope.ActivityScope;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class PhotoModule {

    @ActivityScope
    @Provides
    PhotoApiService providePhotoApiService(Retrofit retrofit){
        return retrofit.create(PhotoApiService.class);
    }


}

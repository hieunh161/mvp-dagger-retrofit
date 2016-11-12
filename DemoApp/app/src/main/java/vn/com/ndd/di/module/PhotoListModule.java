package vn.com.ndd.di.module;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import vn.com.ndd.data.rest.PhotoApiService;
import vn.com.ndd.di.scope.ActivityScope;
import vn.com.ndd.presentation.view.PhotoListView;

/**
 * Created by hieunh on 11/13/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */
@Module
public class PhotoListModule {
    /**
     * The M view.
     */
    PhotoListView mView;

    /**
     * Instantiates a new Photo list module.
     *
     * @param view the view
     */
    public PhotoListModule(PhotoListView view){
        this.mView = view;
    }

    /**
     * Get login api service photo api service.
     *
     * @param retrofit the retrofit
     * @return the photo api service
     */
    @ActivityScope
    @Provides
    PhotoApiService getLoginApiService(Retrofit retrofit){
        return retrofit.create(PhotoApiService.class);
    }

    /**
     * Provide photo list view photo list view.
     *
     * @return the photo list view
     */
    @ActivityScope
    @Provides
    PhotoListView providePhotoListView(){
        return mView;
    }
}

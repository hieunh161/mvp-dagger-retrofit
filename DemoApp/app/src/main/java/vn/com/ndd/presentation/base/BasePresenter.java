package vn.com.ndd.presentation.base;


import javax.inject.Inject;

/**
 * Created by hieunh on 11/10/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 *
 * @param <V> the type parameter
 */
public abstract class BasePresenter<V extends BaseView> {

    /**
     * The M view.
     */
    @Inject
    V mView;

    /**
     * Get view v.
     *
     * @return the v
     */
    protected V getView(){
        return mView;
    }

    /**
     * Method that control the lifecycle of the view. It should be called in the view's
     * (Activity or Fragment) onDestroy() method.
     */
    public void destroy(){

    }
}

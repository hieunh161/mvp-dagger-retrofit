package vn.com.ndd.domain.interactor;

import rx.Subscriber;

/**
 * Created by hieunh on 11/27/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 */

public class DefaultSubscriber<T> extends Subscriber<T> {
    /**
     * Notifies the Observer that the {@link rx.Observable} has finished sending push-based notifications.
     * <p>
     * The {@link rx.Observable} will not call this method if it calls {@link #onError}.
     */
    @Override
    public void onCompleted() {

    }

    /**
     * Notifies the Observer that the {@link rx.Observable} has experienced an error condition.
     * <p>
     * If the {@link rx.Observable} calls this method, it will not thereafter call {@link #onNext} or
     * {@link #onCompleted}.
     *
     * @param e the exception encountered by the Observable
     */
    @Override
    public void onError(Throwable e) {

    }

    /**
     * Provides the Observer with a new item to observe.
     * <p>
     * The {@link rx.Observable} may call this method 0 or more times.
     * <p>
     * The {@code Observable} will not call this method again after it calls either {@link #onCompleted} or
     * {@link #onError}.
     *
     * @param t the item emitted by the Observable
     */
    @Override
    public void onNext(T t) {

    }
}

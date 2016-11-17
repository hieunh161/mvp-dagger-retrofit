package vn.com.ndd.domain.interactor;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by hieunh on 11/12/2016.
 * for NDD
 * You can contact me at hieunh161@gmail.com
 * <p>
 * This class is contract for any use-case of our application
 * </p>
 */
public abstract class UseCase {

    // use for un-subscribe
    private Subscription subscription = Subscriptions.empty();

    private Observable observable;

    /**
     * Subscribe.
     *
     * @param <T>      the type parameter
     * @param observer the observer
     */
    public <T> void subscribe(Observer<T> observer) {
        this.subscription = getObservable()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

    /**
     * Un-subscribe.
     */
    public void unsubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * Build use case observable observable.
     *
     * @return the observable
     */


    public Observable getObservable() {
        return observable;
    }

    public void setObservable(Observable observable) {
        this.observable = observable;
    }
}
